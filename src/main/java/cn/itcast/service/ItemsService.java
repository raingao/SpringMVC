package cn.itcast.service;

import cn.itcast.pojo.ItemsCustom;
import cn.itcast.pojo.ItemsQueryVo;

import java.util.List;

public interface ItemsService {
	
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	void deleteItemsById(Integer id) throws Exception;

	ItemsCustom findItemsById(Integer id) throws Exception;

	void updateItemsById(ItemsCustom itemsCustom) throws Exception;
}
