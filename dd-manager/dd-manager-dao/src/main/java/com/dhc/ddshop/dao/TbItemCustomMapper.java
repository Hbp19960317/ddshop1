package com.dhc.ddshop.dao;



import com.dhc.ddshop.pojo.vo.TbItemCustom;



import java.util.List;
import java.util.Map;

/**
 * 自定义商品实体数据访问层接口
 */
public interface TbItemCustomMapper {
    /**
     * 查询商品表中所有记录的数量
     * @return
     */
    int countItems();

    /**
     * 查询指定页码显示记录集合
     * @param map
     * @return
     */

    List<TbItemCustom> listItemsByPage(Map<String,Object> map);

}
