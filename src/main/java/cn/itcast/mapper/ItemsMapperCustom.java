package cn.itcast.mapper;

import cn.itcast.pojo.ItemsCustom;
import cn.itcast.pojo.ItemsQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mingze-2 on 2017/3/2.
 */
@Repository
public interface ItemsMapperCustom {

    List <ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    void deleteItemsById(Integer id) throws Exception;

    ItemsCustom findItemsById(Integer id) throws Exception;

    void updateItemsById(ItemsCustom itemsCustom) throws Exception;
}
