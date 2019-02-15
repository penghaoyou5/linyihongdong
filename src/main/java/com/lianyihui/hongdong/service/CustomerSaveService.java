package com.lianyihui.hongdong.service;/**
 * Created by penghaoyou on 2019/2/14
 */

import com.lianyihui.hongdong.dao.CustomerInfoDao;
import com.lianyihui.hongdong.model.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program lianyihongdong
 *
 * @description
 *
 * @author penghaoyou
 *
 * @date 2019-02-14 09:14
 **/
@Service
@Slf4j
public class CustomerSaveService {

	@Autowired
	CustomerInfoDao customerInfoDao;
	public void saveone(String working_ground,
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
						String half_comment) {
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setWorkingGround(working_ground);
		customerInfo.setName(name);
		customerInfo.setChineseZodiac(chinese_zodiac);
		customerInfo.setSex(sex);
		customerInfo.setAge(age);
		customerInfo.setHeight(height);
		customerInfo.setEducation(education);
		customerInfo.setWeight(weight);
		customerInfo.setNativePlace(native_place);
		customerInfo.setWorkingCompany(working_company);
		customerInfo.setMemberOfFamily(member_of_family);
		customerInfo.setContactWay(contact_way);
		customerInfo.setMyseltComment(myselt_comment);
		customerInfo.setHalfHeightBig(half_height_big);
		customerInfo.setHalfHeightLittle(half_height_little);
		customerInfo.setHalfAgeBig(half_age_big);
		customerInfo.setHalfAgeLittle(half_age_little);
		customerInfo.setHalfComment(half_comment);


		customerInfoDao.save(customerInfo);
	}
}
