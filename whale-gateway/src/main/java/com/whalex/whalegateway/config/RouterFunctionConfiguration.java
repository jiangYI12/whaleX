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

package com.whalex.whalegateway.config;

import com.whalex.whalegateway.handler.SwaggerResourceHandler;
import com.whalex.whalegateway.handler.SwaggerSecurityHandler;
import com.whalex.whalegateway.handler.SwaggerUiHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * 路由配置
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class RouterFunctionConfiguration {

	private final SwaggerResourceHandler swaggerResourceHandler;

	private final SwaggerSecurityHandler swaggerSecurityHandler;

	private final SwaggerUiHandler swaggerUiHandler;

	@Bean
	public RouterFunction routerFunction() {
		return RouterFunctions
				.route(RequestPredicates.GET("/swagger-resources").and(RequestPredicates.accept(MediaType.ALL)),
						swaggerResourceHandler)
				.andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
						.and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
				.andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
						.and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);

	}

}
