package cn.itcast.controller;

import cn.itcast.pojo.ItemsCustom;
import cn.itcast.pojo.ItemsQueryVo;
import cn.itcast.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/items")
public class StartController {

    @Autowired
    private ItemsService itemsService;

    /**
     * 进入商品查询界面，暂时不分页
     */
    @RequestMapping("/queryAll")
    public ModelAndView itemsQuery() {
        ModelAndView modelAndView = new ModelAndView();
        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        List<ItemsCustom> items = new ArrayList<ItemsCustom>();
        try {
            items = itemsService.findItemsList(itemsQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("items", items);
        modelAndView.setViewName("items");
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

    /**
     * 更新当前信息
     */
    @RequestMapping("/updateItems")
    public String updateItems(HttpServletRequest request, ItemsCustom itemsCustom, MultipartFile items_pic) {
        try {
            //创建存储路径
//            String path = request.getSession().getServletContext().getRealPath("upload");
            String path = request.getSession().getServletContext().getRealPath("/") + "resources/upload";
            //文件名称xxx.jpg
            String old_name = items_pic.getOriginalFilename();
            System.out.println("oldname is " + old_name);
            //获取文件后缀.jpg并添加到随机名称UUID
            String new_name = UUID.randomUUID() + old_name.substring(old_name.lastIndexOf("."));
            System.out.println("new name is" + new_name);

            File pic = new File(path, new_name);
            //如果文件不存在，则创建
            if (!pic.exists()) {
                pic.mkdirs();
            }
            //文件转存
            items_pic.transferTo(pic);

            itemsCustom.setPic(new_name);

            itemsService.updateItemsById(itemsCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:queryAll";
    }


}
