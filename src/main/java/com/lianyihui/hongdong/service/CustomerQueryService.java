package com.lianyihui.hongdong.service;

import com.google.common.collect.Lists;
import com.lianyihui.hongdong.dao.CustomerInfoDao;
import com.lianyihui.hongdong.model.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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

	public List<CustomerInfo> apiqueryinfo(String working_ground,
						String name,
						String sex,
						String chinese_zodiac,
						Integer age,
						Integer height,
						String education,
						Integer weight,
						String native_place,
						String working_company,
						String member_of_family,
						String contact_way,
						String myselt_comment,
						Integer half_height_little,
						Integer half_height_big,
						Integer half_age_little,
						Integer half_age_big,
						String half_comment){


		Iterable<CustomerInfo> bySexAndAgeBetween = customerInfoDao.findBySexAndAgeBetween(sex, half_age_little, half_age_big);
		return Lists.newArrayList(bySexAndAgeBetween);
	}



}
