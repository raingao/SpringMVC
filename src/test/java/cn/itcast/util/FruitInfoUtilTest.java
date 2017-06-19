package cn.itcast.util;

import cn.itcast.pojo.Apple;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaoyu on 2017/6/8.
 * Wish you a good day~
 */
public class FruitInfoUtilTest {
    @Test
    public void getFruitInfo() throws Exception {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }

}