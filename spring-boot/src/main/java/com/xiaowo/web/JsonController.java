package com.xiaowo.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wubo on 2016/12/14.
 */
@Api(description = "RESTfull  测试相关")
@RestController
public class JsonController {


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Object returnJson(@RequestParam(required = false, value = "list[]") List<String> list) throws Exception {

        System.out.println(list);
        return list;
    }


}