package cn.itcast.bean;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaoyu on 2017/6/10.
 * Wish you a good day~
 */
public class MapTest {
    private HashMap<String, String> map = new HashMap<String, String>();

    public MapTest() {
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public Map<String, String> getMap() {
        return map;
    }
}
