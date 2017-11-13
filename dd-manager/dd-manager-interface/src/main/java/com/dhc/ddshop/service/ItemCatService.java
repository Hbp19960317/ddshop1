package com.dhc.ddshop.service;

import com.dhc.ddshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {
    List<TreeNode> listItemCatsByPid(Long parentId);
}
