package com.dhc.ddshop.web;

import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String  page(@PathVariable("page") String page, Model model){
        if (page.equals("item-list")){
            List<TbItem> tbItems=itemService.getAll();
            model.addAttribute("list",tbItems);
        }

        return page;
    }

    @ResponseBody
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
    }
}
