package com.xinrui.pojo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 二叉树
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BinaryTree implements Tree{
    //表示根节点
    private Node root;


    @Override
    public Node findLeftDeepest(Node node) {
        if(node != null){
            Node leftNode = node.getLeftChild();
            if(leftNode.getLeftChild() == null){
                return leftNode;
            }else{
                findLeftDeepest(leftNode);
            }
        }
        return node;
    }

    /*
    * 出账
    * */
    @Override
    public Node findRightDeepest(Node node) {
        if(node != null){
            Node right = node.getRightChild();
            if(right == null){
                Node parent = getParent(right);
                if(parent == null){
                    return right;
                }else {
                    findRightDeepest(parent);
                }
            }
        }
        return null;
    }

    public Node getParent(Node node)
    {
        return (root == null || root == node) ? null : parent(root, node);
    }

    public Node parent(Node subTree, Node element)
    {
        if (subTree == null)
            return null;
        if (subTree.getLeftChild() == element || subTree.getRightChild() == element)
            // 返回父结点地址
            return subTree;
        Node p;
        // 现在左子树中找，如果左子树中没有找到，才到右子树去找
        if ((p = parent(subTree.getLeftChild(), element)) != null)
            // 递归在左子树中搜索
            return p;
        else
            // 递归在右子树中搜索
            return parent(subTree.getRightChild(), element);
    }


    @Override
    public Node find(int key) {
        return null;
    }

    @Override
    public boolean insert(int data) {
        return false;
    }

    @Override
    public void infixOrder(Node current) {

    }

    @Override
    public void preOrder(Node current) {

    }

    @Override
    public void postOrder(Node current) {

    }

    @Override
    public Node findMax() {
        return null;
    }

    @Override
    public Node findMin() {
        return null;
    }

    @Override
    public boolean delete(int key) {
        return false;
    }
}