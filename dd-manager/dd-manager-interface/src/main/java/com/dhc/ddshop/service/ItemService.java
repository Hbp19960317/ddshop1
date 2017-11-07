package com.dhc.ddshop.service;

import com.dhc.ddshop.pojo.po.TbItem;

import java.util.List;

public interface ItemService {

    //根据id查找
    TbItem getById(Long itemId);


    List<TbItem> getAll();
}
