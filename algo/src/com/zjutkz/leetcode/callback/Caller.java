package com.zjutkz.leetcode.callback;

/**
 * 模拟我调用你的类
 */
public class Caller {

    public static void main(String[] args) {
        NetworkParam param = new NetworkParam();
        param.setIp("1.1.1.1");
        param.setPort("8080");
        param.setPath("/path");
        param.setType("http");

        /**
         * 这里的第二个参数是一个java中的匿名内部类
         */
        NetworkClient.detect(param, new NetworkCallback() {
            @Override
            public void done(NetworkResponse response) {
                // 我可以在这里拿到对应的response，做处理
            }
        });
    }
}
