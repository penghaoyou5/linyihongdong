package com.lianyihui.hongdong.controller;

import com.lianyihui.hongdong.data.response.APIResponse;
import com.lianyihui.hongdong.model.CustomerInfo;
import com.lianyihui.hongdong.service.CustomerQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

/**
 * @author
 * Created by penghaoyou on 2019/2/12
 */
@Slf4j
@RestController
public class CustomerQuery {
	@Autowired
	CustomerQueryService customerQueryService;
	/**
	 * @return
	 */
	@RequestMapping("/api/v1/getallcusomer")
	public APIResponse getAllCustomer() {
		List<CustomerInfo> infoList = customerQueryService.getAllCustomer();
		return APIResponse.result(infoList);
	}
	@Autowired
	private TemplateEngine templateEngine;


	@RequestMapping("/apiqueryinfo")
	public String apiqueryinfo(
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
	){
		List<CustomerInfo> customerInfos = customerQueryService.apiqueryinfo(working_ground, name, sex, chinese_zodiac, age, height, education, weight, native_place, working_company, member_of_family, contact_way, myselt_comment, half_height_little, half_height_big, half_age_little, half_age_big, half_comment);
		Context context = new Context();
		context.setVariable("customerInfos", customerInfos);
		return templateEngine.process("resultlist", context);
	}

}
