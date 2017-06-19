package cn.itcast.service.impl;

import cn.itcast.mapper.ItemsMapperCustom;
import cn.itcast.pojo.ItemsCustom;
import cn.itcast.pojo.ItemsQueryVo;
import cn.itcast.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "itemsService")
@Transactional
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    //查询所有商品列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsCustomsList;
        itemsCustomsList = itemsMapperCustom.findItemsList(itemsQueryVo);
        return itemsCustomsList;
    }

    //根据id删除单条商品记录
    public void deleteItemsById(Integer id) throws Exception {
        itemsMapperCustom.deleteItemsById(id);

    }

    //根据id查找单条商品记录
    public ItemsCustom findItemsById(Integer id) throws Exception {
        ItemsCustom itemsById = itemsMapperCustom.findItemsById(id);
        return itemsById;
    }

    //根据id跟po修改单条商品记录
    public void updateItemsById(ItemsCustom itemsCustom) throws Exception {
        ItemsCustom item = itemsMapperCustom.findItemsById(itemsCustom.getId());
        if (item.equals(itemsCustom))
            return;
        itemsMapperCustom.updateItemsById(itemsCustom);
    }
}
