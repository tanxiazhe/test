package com.test.loadBalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 随机法
 * Created by zhang on 17/1/17.
 */
public class Random {
    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        // 获取Ip地址List
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        java.util.Random random = new java.util.Random();
        int pos = random.nextInt(keyList.size());

        return keyList.get(pos);
    }
}