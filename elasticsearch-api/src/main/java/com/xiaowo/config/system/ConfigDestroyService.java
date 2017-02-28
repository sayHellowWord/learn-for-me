package com.xiaowo.config.system;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * 服务销毁
 */
@Component
public class ConfigDestroyService implements DisposableBean, ExitCodeGenerator {

    @PreDestroy
    @Override
    public void destroy() throws Exception {
        System.out.println("<<<<<<<<<<<我被销毁了......................>>>>>>>>>>>>>>>");
        System.out.println("<<<<<<<<<<<我被销毁了......................>>>>>>>>>>>>>>>");
    }

    @Override
    public int getExitCode() {
        System.out.println("<<<<<<<<<<<退出......................>>>>>>>>>>>>>>>");
        return 5;
    }
}
