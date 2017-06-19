package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gaoyu on 2017/6/7.
 * Wish you a good day~
 */
@Controller
@RequestMapping("/login")
public class UserController {

    //    @Authority
    @RequestMapping(value = {"/userlogin", "/adminlogin"}, method = RequestMethod.POST)
    public void login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpServletResponse response) {
        try {
            response.setContentType("text/html, charset=utf8");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(username + password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
