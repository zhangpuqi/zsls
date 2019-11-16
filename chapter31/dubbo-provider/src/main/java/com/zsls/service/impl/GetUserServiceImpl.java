package com.zsls.service.impl;

import com.zsls.entity.User;
import com.zsls.service.GetUserService;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetUserServiceImpl implements GetUserService {

    @Override
    public List<User> getUserList(String name) {
        //此处没有连接数据库，所以就先生成几条数据返回即可。
        System.out.println(name);
        List<User> list = new ArrayList<>();
        list.add(new User("小明",20));
        list.add(new User("小强",21));
        list.add(new User("小红",22));
        return list;
    }
}