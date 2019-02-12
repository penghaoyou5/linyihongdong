package com.lianyihui.hongdong.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by penghaoyou on 2019/2/12
 */
@Entity
@Table(name = "customer_info")
@Data
@NoArgsConstructor
public class CustomerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Column(name = "create_date")
	protected Timestamp createDate;
	@Column(name = "working_ground")
	String workingGround;
	String name;
	String sex;
	@Column(name = "chinese_zodiac")
	String chineseZodiac;
	Integer age;
	Integer height;
	String education;
	Integer weight;
	@Column(name = "native_place")
	String nativePlace;
	@Column(name = "working_company")
	String workingCompany;
	@Column(name = "member_of_family")
	String memberOfFamily;
	@Column(name = "contact_way")
	String contactWay;
	@Column(name = "myselt_comment")
	String myseltComment;
	@Column(name = "half_height_little")
	Integer halfHeightLittle;
	@Column(name = "half_height_big")
	Integer halfHeightBig;
	@Column(name = "half_age_little")
	Integer halfAgeLittle;
	@Column(name = "half_age_big")
	Integer halfAgeBig;
	@Column(name = "half_comment")
	String halfComment;
}
