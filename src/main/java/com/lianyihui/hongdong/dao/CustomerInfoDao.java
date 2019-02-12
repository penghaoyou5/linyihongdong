package com.lianyihui.hongdong.dao;

import com.lianyihui.hongdong.model.CustomerInfo;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * @author
 * Created by penghaoyou on 2019/2/12
 */
@Transactional
public interface CustomerInfoDao extends CrudRepository<CustomerInfo, Long> {
}
