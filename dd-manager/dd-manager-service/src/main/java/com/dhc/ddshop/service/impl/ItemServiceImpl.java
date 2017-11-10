package com.dhc.ddshop.service.impl;

import com.dhc.ddshop.common.dto.Order;
import com.dhc.ddshop.common.dto.Page;
import com.dhc.ddshop.common.dto.Result;
import com.dhc.ddshop.dao.TbItemCustomMapper;
import com.dhc.ddshop.dao.TbItemMapper;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.po.TbItemExample;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
import com.dhc.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TbItemMapper itemDao;
@Autowired
    private TbItemCustomMapper itemCustomDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem=itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }

    /*@Override
    public List<TbItem> getAll() {
        return itemDao.selectByExample(null);
    }

    @Override
    public List<TbItem> listItems() {
        List<TbItem> list=null;
        try {
            list=itemDao.selectByExample(null);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }*/

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page, Order order) {
        Result<TbItemCustom> result = null;
        try {
            //创建以一个MAp封装前台传递过来的参数
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
            //1创建一个响应参数实体类
            result=new Result<TbItemCustom>();

            int total=itemCustomDao.countItems();
            //2对total进行设值(符合条件的总记录数)
            result.setTotal(total);
            //3对rows进行设值(指定页码显示记录集合)
           List<TbItemCustom> list= itemCustomDao.listItemsByPage(map);
           result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBatch(List<Long> ids) {
        int i=0;
        try {
            //准备商品对象,这个对象包含了状态为3的字段
            TbItem record=new TbItem();
            //修改为3
            record.setStatus((byte)3);
            //创建更新模板 update tb_item set status? where id in(?,?..)
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新
           i=itemDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return i;
    }

    @Override
    public int updateIconup(List<Long> ids) {
        int i=0;
        try{
            TbItem record=new TbItem();
            record.setStatus((byte)1);
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            i=itemDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return i;
    }

    @Override
    public int updateIcondown(List<Long> ids) {
        int i=0;
        try{
            TbItem record=new TbItem();
            record.setStatus((byte)2);
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            i=itemDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return i;
    }
}
