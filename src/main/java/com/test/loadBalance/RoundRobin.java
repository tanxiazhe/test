package com.test.loadBalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 轮询法
 * Created by zhang on 17/1/17.
 */
public class RoundRobin {
    private static Integer pos = 0;

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        // 获取Ip地址List
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        String server;
        synchronized (pos) {
            if (pos >= keySet.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;
        }
        return server;
    }
}