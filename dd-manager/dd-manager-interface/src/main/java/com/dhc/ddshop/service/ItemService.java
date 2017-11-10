package com.dhc.ddshop.service;

import com.dhc.ddshop.common.dto.Order;
import com.dhc.ddshop.common.dto.Page;
import com.dhc.ddshop.common.dto.Result;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface ItemService {

    //根据id查找
    TbItem getById(Long itemId);

   //查找所有
    //List<TbItem> getAll();

    //List<TbItem> listItems();

    Result<TbItemCustom> listItemsByPage(Page page, Order order);

    int updateBatch(List<Long> ids);

    int updateIconup(List<Long> ids);

    int updateIcondown(List<Long> ids);
}
