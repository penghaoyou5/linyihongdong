package com.lianyihui.hongdong.controller;

import com.lianyihui.hongdong.data.response.APIResponse;
import com.lianyihui.hongdong.model.CustomerInfo;
import com.lianyihui.hongdong.service.CustomerQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
