package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gaoyu on 2017/6/13.
 * Wish you a good day~
 */
@RequestMapping("/")
@Controller
public class DefaultController {

    @RequestMapping("/")
    public String defaultDispatcher() {
        return "index";
    }

}
