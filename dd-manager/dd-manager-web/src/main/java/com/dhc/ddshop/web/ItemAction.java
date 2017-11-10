package com.dhc.ddshop.web;

import com.dhc.ddshop.common.dto.Order;
import com.dhc.ddshop.common.dto.Page;
import com.dhc.ddshop.common.dto.Result;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
import com.dhc.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Scope("prototype")
public class ItemAction {

   @Autowired
private ItemService itemService;

   private Logger logger= LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId){
        System.out.println(itemId);
       /* itemService.getById(itemId);*/
        return   itemService.getById(itemId);
    }

    @RequestMapping("/{page}")
    public String  page(@PathVariable("page") String page){


        return page;
    }

   /* @ResponseBody
    @RequestMapping("/items")
    public List<TbItem> listItems(){
        List<TbItem> list=null;
        try {
            list=itemService.listItems();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }*/

   //分页查找所有
    @ResponseBody
    @RequestMapping("/items")
   public Result<TbItemCustom> listItemsByPage(Page page, Order order){
        Result<TbItemCustom> list=null;
        try {
            list=itemService.listItemsByPage(page,order);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
   }

   //删除
   @ResponseBody
   @RequestMapping("/items/batch")
   public int updateBatch(@RequestParam("ids[]")List<Long> ids){
       int i=0;
       try {
           i=itemService.updateBatch(ids);
       }catch (Exception e){
           logger.error(e.getMessage(),e);
       }
       return i;
   }

   //上架
    @ResponseBody
    @RequestMapping("/items/iconup")
    public int updateIconup(@RequestParam("ids[]")List<Long> ids){
        int i=0;
        try {
            i=itemService.updateIconup(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return i;
    }


    //下架
    @ResponseBody
    @RequestMapping("/items/icondown")
    public int updateIcondown(@RequestParam("ids[]")List<Long> ids){
        int  i=0;
        try{
            i=itemService.updateIcondown(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return i;
    }
}
