package com.zjutkz.leetcode.callback;

/**
 * 这里定义一个callback，是一个java的接口，方法里的参数就是对应的response
 */
public interface NetworkCallback {

    void done(NetworkResponse response);
}
