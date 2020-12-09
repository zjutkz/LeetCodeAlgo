package com.zjutkz.leetcode.android.stack;


import java.util.Stack;

public class Stack2Queue {
    private Stack<Integer> s1;   //入队用的栈
    private Stack<Integer> s2;   //出队用的栈

    public Stack2Queue() {
        this(3);  //默认容量为3
    }

    public Stack2Queue(int capacity) {
        s1=new Stack();
        s2=new Stack();
    }

    //入队
    public void add(int value) {
        s1.push(value);
    }

    //出队
    public int remove() {
        //如果第二个栈不为空，就直接出栈
        if(!s2.isEmpty()) {
            return s2.pop();
        }
        //否则第二个栈为空，则把第一个栈的元素装入第二个栈，实现顺序，s2栈顶就是最先加入的
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        //再弹出栈顶元素
        return s2.pop();
    }


    //测试
    public static void main(String[] args) {
        Stack2Queue queue=new Stack2Queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("出队："+queue.remove());
        System.out.println("出队："+queue.remove());
        System.out.println("出队："+queue.remove());
    }
}
