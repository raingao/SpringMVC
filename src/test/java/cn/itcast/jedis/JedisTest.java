package cn.itcast.jedis;


import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by gaoyu on 2017/6/9.
 * Wish you a good day~
 */

public class JedisTest {

    private Jedis jedis;

    @Before
    public void setUp() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
        String url = resourceBundle.getString("redis.host");
        String port = resourceBundle.getString("redis.port");
        jedis = new Jedis(url, Integer.valueOf(port));
        System.out.println(url);
        System.out.println(port);
    }

    @Test
    public void jedisString() {
        jedis.watch("user:userid:1:username", "user:userid:2:username");
        Set<String> names = jedis.keys("user:userid:1:username");
        long length = jedis.dbSize();

        System.out.println("dbSize: " + length);
        for (String name : names) {
            System.out.println(jedis.get(name));
        }
    }

}
