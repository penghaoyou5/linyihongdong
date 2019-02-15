#!/bin/bash

PRG="$0"
BIN=`cd $(dirname "$PRG"); pwd`
HOME=`dirname "$BIN"`
LOG_DIR=/data/log/lianyihongdong
PID_FILE=/var/run/lianyihongdong.pid

test_running() {
    java -version
    if [ $? != 0 ]; then
      echo "java not installed... "
      exit 1
    fi
    if [ -e "$PID_FILE" ]; then
      pid=`cat $PID_FILE`
      tr=`jps | grep $pid`
      if [ "x$tr" != "x" ] ; then
        return 1
      fi
    fi
    return 0
}

start() {
    test_running
    is_running=$?
    if [ "$is_running" == 1 ]; then
        echo "lianyihongdong is running"
        exit 1
    fi
    JAR_PATH=`find $HOME -maxdepth 1 -name "lianyihongdong-*.jar"`

    JVM_OPTS="-server -Xms8g -Xmx16g"
    JVM_OPTS="$JVM_OPTS -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled"
    JVM_OPTS="$JVM_OPTS -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70"
    JVM_OPTS="$JVM_OPTS -XX:+ScavengeBeforeFullGC -XX:+CMSScavengeBeforeRemark"
    JVM_OPTS="$JVM_OPTS -XX:+PrintGCDetails -XX:+PrintGCDateStamps -verbose:gc -Xloggc:$LOG_DIR/gc.log "
    JVM_OPTS="$JVM_OPTS -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100m"
    JVM_OPTS="$JVM_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG_DIR/`date '+%Y%m%d%H%M%S'`.hprof"

    mkdir -p ${LOG_DIR}
    echo $JAR_PATH
    java $JVM_OPTS -jar $JAR_PATH --spring.profiles.active=prod --logging.path=$LOG_DIR > ${LOG_DIR}/start.log 2>&1 &
    echo $! > $PID_FILE
    echo "starting lianyihongdong..."
    counter=0
    response=$(curl -sL 127.0.0.1:9012/health)
    while [[ $response != *"UP"* ]]; do
        counter=$((counter+1))
        if [[ $counter -gt 60 ]]; then
            echo
            echo "Check port timeout after 60s. Failed to start lianyihongdong, please check logs manually..."
            exit 1
        fi
        echo -n "."
        sleep 1
        response=$(curl -sL 127.0.0.1:80/health)
    done
    echo
    echo "successfully start lianyihongdong..."
}

stop() {
    test_running
    is_running=$?
    if [ "$is_running" == 1 ]; then
        PID=`cat $PID_FILE`
        kill $PID
        echo "stopping lianyihongdong..."
        sleep 1
        counter=0
        while ps -p $PID > /dev/null; do
            counter=$((counter+1))
            if [[ $counter -gt 60 ]]; then
                echo
                echo "Still alive after 60s. Failed to stop lianyihongdong, please check it manually..."
                exit 1
            fi
            echo -n "."
            sleep 1
        done
        rm $PID_FILE
    fi
    echo
    echo "stopped lianyihongdong..."
}

case "$1" in
start)
    start
    ;;
stop)
    stop
    ;;
restart)
    stop
    start
    ;;
status)
    test_running
    is_running=$?
    if [ "$is_running" == 1 ]; then
        echo "lianyihongdong is running"
    else
        echo "lianyihongdong is NOT running"
        exit 1
    fi
    ;;
*)
    echo "Usage: $0 {start|stop|status|restart}"
esac


