package com.lianyihui.hongdong.service;

import com.google.common.collect.Lists;
import com.lianyihui.hongdong.dao.CustomerInfoDao;
import com.lianyihui.hongdong.model.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author
 * Created by penghaoyou on 2019/2/12
 */

@Service
@Slf4j
public class CustomerQueryService {
	@Autowired
	CustomerInfoDao customerInfoDao;


	@RequestMapping("/api/v1/getAllCustomer")
	public List<CustomerInfo> getAllCustomer() {
		Iterable<CustomerInfo> customerInfos = customerInfoDao.findAll();
		return Lists.newArrayList(customerInfos);
	}

}
