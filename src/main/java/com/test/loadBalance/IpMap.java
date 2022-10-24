/**
 * 
 */
package com.test.loadBalance;

/**
 * @author 
 *
 */
import java.util.HashMap;

/**
 * 服务器地址池
 * Created by zhang on 17/1/17.
 */
public class IpMap {
    public static HashMap<String, Integer> serverWeightMap = new HashMap<String, Integer>();
    static {
        serverWeightMap.put("192.168.30.201", 1);
        serverWeightMap.put("192.168.30.112", 2);
        serverWeightMap.put("192.168.30.124", 3);
        serverWeightMap.put("192.168.30.223", 4);
        serverWeightMap.put("192.168.30.110", 2);
        serverWeightMap.put("192.168.30.118", 1);
        serverWeightMap.put("192.168.30.200", 5);
    }
}