package com.zsls.service;


import com.zsls.entity.User;

public interface UserService {

    /**
     * 删除
     *
     * @param user 用户对象
     * @return 操作结果
     */
    User saveOrUpdate(User user);

    /**
     * 添加
     *
     * @param id key值
     * @return 返回结果
     */
    User get(Integer id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Integer id);
}
