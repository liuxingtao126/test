package com.mocha.work.tree;

public class TreeNode {
	String value;
    TreeNode left_Node;
    TreeNode right_Node;
    
    //TreeNode构造函数
    public TreeNode(final String value) {
        this.value=value;
        this.left_Node=null;
        this.right_Node=null;
    }
}