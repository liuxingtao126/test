package com.mocha.work.testWork;

public class TestTree{
    int data;
    TestTree leftNode;
    TestTree rightNode;
    public TestTree(){
    }
    public TestTree(final int data){
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
    public TestTree(final int data,final TestTree leftNode,final TestTree rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
	
    
  
    
    
    
}






