package com.lianyihui.hongdong.controller;/**
 * Created by penghaoyou on 2019/2/14
 */

import com.lianyihui.hongdong.data.response.APIResponse;
import com.lianyihui.hongdong.service.CustomerSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author penghaoyou
 * @program lianyihongdong
 * @description 进行用户信息保存的接口
 * @date 2019-02-14 09:12
 **/
@Slf4j
@RestController
public class CustomerSave {

	@Autowired
	CustomerSaveService saveService;

	@RequestMapping("/apisaveone")
	private APIResponse apisaveone(
			String working_ground,
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
			String half_comment


	) {
		saveService.saveone(working_ground,name ,sex ,chinese_zodiac ,age , height,education ,weight ,native_place ,working_company ,member_of_family ,contact_way ,myselt_comment ,half_height_little ,half_height_big ,half_age_little , half_age_big, half_comment);
		return APIResponse.ok();
	}


}
