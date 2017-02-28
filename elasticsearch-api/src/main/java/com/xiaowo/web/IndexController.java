package com.xiaowo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    @ResponseBody
    public void IndexController() {

        System.out.println("。。。。。。。。。");
    }
}
