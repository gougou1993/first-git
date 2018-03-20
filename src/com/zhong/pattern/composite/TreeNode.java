package com.zhong.pattern.composite;

import java.util.Enumeration;
import java.util.Vector;

public class TreeNode {
	
	private String name;
	private Object data;
	private TreeNode parent;
	private Vector<TreeNode> childrens = new Vector<TreeNode>();
	
	public TreeNode(String name, Object data) {
		super();
		this.name = name;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	//添加孩子节点  
    public void add(TreeNode node){  
        childrens.add(node);  
    }  
      
    //删除孩子节点  
    public void remove(TreeNode node){  
        childrens.remove(node);  
    }  
      
    //取得孩子节点  
    public Enumeration<TreeNode> getChildrens(){  
        return childrens.elements();  
    }  

}
