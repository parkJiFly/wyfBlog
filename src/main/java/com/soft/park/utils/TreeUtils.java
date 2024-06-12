package com.soft.park.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/11 18:00
 * @description
 */
public class TreeUtils {

	/**
	 * 创建树结点
	 * @param list
	 * @return
	 * @param <T>
	 */
	public static <T extends TreeObject> List<T> buildTree(List<T> list) {
		List<T> treeList = new ArrayList<>();
		for (T node : list){
			if("0".equals(node.parentId())){
				treeList.add(findChild(node,list));
			}
		}
		return treeList;
	}

	/**
	 * 查找子节点构建树
	 * @param parentNode
	 * @param list
	 * @return
	 * @param <T>
	 */
	private static <T extends TreeObject> T findChild(T parentNode, List<T> list) {
		parentNode.setChildren(new ArrayList<>());
		for (T node : list){
			if(Objects.equals(node.parentId(),parentNode.id())){
				parentNode.getChildren().add(findChild(node,list));
			}
		}
		return parentNode;
	}

}
