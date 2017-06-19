package cn.itcast.service.impl;

import cn.itcast.mapper.AdminMapper;
import cn.itcast.pojo.Admin;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaoyu on 2017/6/6.
 * Wish you a good day~
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findUserByUserName(String userName) {
        Admin admin = adminMapper.findUserByUserName(userName);
        return admin;
    }

    @Override
    public Integer findRoleIdByUserName(String userName) {
        Integer roleId = adminMapper.findRoleIdByUserName(userName);
        return roleId;
    }
}
