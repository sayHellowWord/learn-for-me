package com.yd.json;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2019/4/18.
 *
 * @author nick
 * @date 2019/4/18
 */
public class TypeR {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");

        JSONObject o = new JSONObject();
        o.put("k",list);

        List<String> types = o.getObject("k",List.class);
        System.out.println(JSON.toJSONString(types));

        List<String> types2 = o.getObject("k",new TypeReference<List<String>>(){});
        System.out.println(JSON.toJSONString(types2));
    }


}
