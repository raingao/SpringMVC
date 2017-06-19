package cn.itcast.mapper;

import cn.itcast.pojo.Admin;

/**
 * Created by gaoyu on 2017/6/6.
 * Wish you a good day~
 */
public interface AdminMapper {

    Admin findUserByUserName(String userName);

    Integer findRoleIdByUserName(String userName);

}
