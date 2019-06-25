package com.xiaowo.spring.boot.bean.impl;

import com.xiaowo.spring.boot.bean.INickService;
import org.springframework.stereotype.Service;

/**
 * Created by nick on 2019/6/4.
 *
 * @author nick
 * @date 2019/6/4
 */
@Service
public class NickServiceimpl implements INickService {

    @Override
    public String test(String name) {
        System.out.println("========================" + name);
        return name;
    }
}
