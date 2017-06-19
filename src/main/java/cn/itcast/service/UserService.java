package cn.itcast.service;

import cn.itcast.pojo.Admin;
import org.springframework.stereotype.Service;

/**
 * Created by gaoyu on 2017/6/6.
 * Wish you a good day~
 */
@Service
public interface UserService {

    Admin findUserByUserName(String userName);

    Integer findRoleIdByUserName(String userName);

    default boolean hasNext(){
        return true;
    }
}
