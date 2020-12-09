package com.zjutkz.leetcode.callback;

public class NetworkClient {

    /**
     *
     * @param param      这个是我传递给你的参数，包含了ip、port、path等信心
     * @param callback   这个是你定义的一个callback
     *                   @see com.zjutkz.leetcode.callback.NetworkCallback
     *                   把执行完的结果放在这个callback中，我可以在调用的时候获取到
     */
    public static void detect(NetworkParam param, NetworkCallback callback) {
        // 这里做你的异步探测逻辑...

        NetworkResponse response = new NetworkResponse();
        response.setData("这里放结果数据，可以不是String，你自己定义一个数据结构");
        callback.done(response);
    }
}
