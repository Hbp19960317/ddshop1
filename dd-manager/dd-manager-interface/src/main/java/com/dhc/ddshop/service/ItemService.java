package com.dhc.ddshop.service;

import com.dhc.ddshop.pojo.po.TbItem;

public interface ItemService {

    //根据id查找
    TbItem getById(Long itemId);
}
