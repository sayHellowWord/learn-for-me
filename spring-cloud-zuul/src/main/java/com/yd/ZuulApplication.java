package com.yd;


import com.yd.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy //启Zuul
@SpringCloudApplication //@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
@EnableCircuitBreaker
public class ZuulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    /**
     * 过滤器
     * @return
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

}