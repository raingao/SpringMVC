package cn.itcast.controller;

import cn.itcast.exception.DiyException;
import cn.itcast.pojo.Admin;
import cn.itcast.pojo.ItemsCustom;
import cn.itcast.pojo.ItemsQueryVo;
import cn.itcast.service.ItemsService;
import cn.itcast.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/items")
public class StartController {

    private static Logger logger = Logger.getLogger(StartController.class);

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private UserService userService;

    /**
     * 进入商品查询界面，暂时不分页
     */
    @RequestMapping("/queryAll")
    public ModelAndView itemsQuery(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        List<ItemsCustom> items = new ArrayList();
        try {
            items = itemsService.findItemsList(itemsQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("items", items);
        modelAndView.setViewName("items");
        logger.info("获取全部商品信息！");
//        logger.debug(request.getAttribute("name"));
        return modelAndView;
    }

    /**
     * 按下删除后删除当前行
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteItems(@PathVariable Integer id) {
        try {
            itemsService.deleteItemsById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/items/queryAll";
    }

    /**
     * 编辑当前行，进入编辑界面，显示单条记录可编辑
     */
    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        //根据id查找单条记录并显示
        ItemsCustom itemsCustom = null;
        try {
            itemsCustom = itemsService.findItemsById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("item", itemsCustom);
        return "editPage";
    }
//    @RequestMapping(value = "/edit/{id}")
//    @ResponseBody
//    public ItemsCustom edit(@PathVariable Integer id, Model model) {
//        //根据id查找单条记录并显示
//        ItemsCustom itemsCustom = null;
//        try {
//            itemsCustom = itemsService.findItemsById(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("item", itemsCustom);
//        return itemsCustom;
//    }

    /**
     * 更新当前信息
     */
    @RequestMapping("/updateItems")
    public String updateItems(HttpServletRequest request, ItemsCustom itemsCustom, MultipartFile items_pic) {
        try {
            //创建存储路径
            String path = request.getSession().getServletContext().getRealPath("upload");
//            String path = request.getSession().getServletContext().getRealPath("/") + "resources/upload";
            //文件名称xxx.jpg
            String old_name = items_pic.getOriginalFilename();
            //声明新的文件名
            String new_name;
            //如果文件不为空的话才改名传递，否则不操作pic字段
            if (old_name != null && !old_name.equals("")) {
                //获取文件后缀.jpg并添加到随机名称UUID
                new_name = UUID.randomUUID() + old_name.substring(old_name.lastIndexOf("."));
                System.out.println("new name is" + new_name);
                File pic = new File(path, new_name);
                //如果文件不存在，则创建
                if (!pic.exists()) {
                    pic.mkdirs();
                }
                //文件转存
                items_pic.transferTo(pic);
                //设置图片名称
                itemsCustom.setPic(new_name);
            }

            //更新商品信息
            itemsService.updateItemsById(itemsCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:queryAll";
    }

    @RequestMapping("/admin/{userName}")
    public @ResponseBody
    Admin admin(@PathVariable("userName") String userName) throws DiyException {
        throw new DiyException("自定义异常");
//        return userService.findUserByUserName(userName);
    }




}
