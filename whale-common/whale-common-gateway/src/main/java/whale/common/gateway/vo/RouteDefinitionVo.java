/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package whale.common.gateway.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.io.Serializable;

/**
 * @description: 路由包装类
 * @author: 🐋鲸鱼
 * @date: 2020/7/6
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RouteDefinitionVo extends RouteDefinition implements Serializable {

	/**
	 * 路由名称
	 */
	private String routeName;

}