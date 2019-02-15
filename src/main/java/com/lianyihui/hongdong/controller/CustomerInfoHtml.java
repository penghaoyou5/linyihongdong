package com.lianyihui.hongdong.controller;/**
 * Created by penghaoyou on 2019/2/14
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @program lianyihongdong
 *
 * @description 前端接口
 *
 * @author penghaoyou
 *
 * @date 2019-02-14 09:04
 **/
@Slf4j
@RestController
public class CustomerInfoHtml {

	@Autowired
	private TemplateEngine templateEngine;

	/**
	 * 保存单个信息前端
	 * @return
	 */
	@RequestMapping("saveone")
	private String getCustInNodeWithAggNode() {
		return templateEngine.process("saveone", new Context());
	}

	/**
	 * 保存单个信息前端
	 * @return
	 */
	@RequestMapping("queryinfo")
	private String queryinfo() {
		return templateEngine.process("queryinfo", new Context());
	}

	@RequestMapping("queryCollect")
	private String queryCollect(){
		return templateEngine.process("query_collet", new Context());
	}



}
