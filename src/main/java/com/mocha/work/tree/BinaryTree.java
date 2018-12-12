package com.mocha.work.tree;

public class BinaryTree {
	public TreeNode rootNode; //二叉树的根节点
	public BinaryTree()
	{
 
    }
	public BinaryTree(final String code,final String letterOrNumb)
	{
		addNodeToTree(code,letterOrNumb);
    }
	//构建二叉树
	// 将指定的值加入到二叉树中适当的节点
    void addNodeToTree(final String code,final String letterOrNumb) {
    	
    	//System.out.println("addNodeToTree---"+letterOrNumb);
    	
    	TreeNode currentNode=rootNode;
    	
    	//System.out.println(currentNode);
    	
        if(rootNode==null) { //建立树根
            rootNode=new TreeNode("Morse");
            return;
        }
    	
        char codeValue ;
        
    	for(int i=0;i<code.length();i++) {
    		
    		codeValue = code.charAt(i);
    		
            //建立二叉树
    		if (codeValue=='-') { //在左子树
                if(currentNode.left_Node==null) {
                    currentNode.left_Node=new TreeNode(letterOrNumb);
                    return;
                }else {//更换当前结点
                	currentNode=currentNode.left_Node;//将当前结点的左子树 为 新的节点
                }
            }
            else  if (codeValue=='.') { //在右子树
                if(currentNode.right_Node==null) {
                    currentNode.right_Node=new TreeNode(letterOrNumb);
                    return;
                }else {//更换当前结点 
                	currentNode=currentNode.right_Node; //将当前结点的右子树 为 新的节点
                }
            }
    		
    	}
        
    }
    
   //中序遍历 
    public void MiddleOrder(final TreeNode node) {
    	if(node!=null) {
    		MiddleOrder(node.left_Node);
    		System.out.print("["+ node.value+"] ");
    		MiddleOrder(node.right_Node);
    	}
    }
    
    public String getLetterOrNumb(final TreeNode rootNode,final String code)
    {
    	TreeNode currentNode = rootNode;
    	//System.out.println(currentNode.value);
    	char codeValue ;

    	for(int i=0;i<code.length();i++) {
    		codeValue = code.charAt(i);
    		if (codeValue=='-') {
    			currentNode=currentNode.left_Node;
    		}
    		else  if (codeValue=='.') {
    			currentNode=currentNode.right_Node;
    		 }
    		
    	}
    	System.out.println(currentNode.value);
    	return currentNode.value;
    }
 
    public static void main(final String[] args) {
    	//e .
    	final BinaryTree binaryTree = new BinaryTree("","Morse");//根左右
    	binaryTree.addNodeToTree(".", "e");
    	binaryTree.addNodeToTree("-", "t");
    	binaryTree.addNodeToTree("--", "m");
    	binaryTree.addNodeToTree("-.", "n");
    	binaryTree.addNodeToTree(".-", "a");
    	binaryTree.addNodeToTree("..", "i");
    	
    	binaryTree.getLetterOrNumb(binaryTree.rootNode,"..");

    	//binaryTree.MiddleOrder(binaryTree.rootNode);//左根右
    	
	}
   
}