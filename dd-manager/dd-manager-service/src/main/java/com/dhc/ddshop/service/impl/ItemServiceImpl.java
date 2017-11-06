package com.dhc.ddshop.service.impl;

import com.dhc.ddshop.dao.TbItemMapper;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {



    @Autowired
    private TbItemMapper itemDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem=itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }
}
