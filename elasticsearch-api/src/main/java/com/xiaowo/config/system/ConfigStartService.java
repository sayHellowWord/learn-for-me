package com.xiaowo.config.system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 服务启动完成初始化操作
 */
@Component
public class ConfigStartService implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("<<<<<<<<<<<启动......................>>>>>>>>>>>>>>>");
    }
}
