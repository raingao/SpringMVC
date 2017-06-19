package cn.itcast.pojo;

import cn.itcast.annotation.FruitColor;
import cn.itcast.annotation.FruitName;
import cn.itcast.annotation.FruitProvider;
import cn.itcast.authEnum.Color;

/**
 * Created by gaoyu on 2017/6/7.
 * Wish you a good day~
 */
public class Apple {

    @FruitName("红富士")
    private String appleName;
    @FruitColor(fruitColor = Color.RED)
    private String appleColor;
    @FruitProvider(id = 11, name = "山西xxx红富士", address = "太原市xx路xx号红富士大厦")
    private String appleProvider;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
