package com.yd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务发现模块：Eureka。  程序入口
 * 注册中心
 */
//EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话
@EnableEurekaServer
@SpringBootApplication
public class Application {

    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class).web(true).run(args);

        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.debug("logback 成功了");

    }
}