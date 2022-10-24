package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/***
 * 
 * @author
 *
 */
public class RedisJava {
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server successfully.");
        System.out.println("Server is running:" + jedis.ping());
        System.out.println();

        jedis.set("string", "redisstring");
        System.out.println("Stored string in redis:: " + jedis.get("string"));
        System.out.println();

        jedis.lpush("list", "redis");
        jedis.lpush("list", "mongodb");
        jedis.lpush("list", "mysql");

        List<String> list = jedis.lrange("list", 0, 5);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stroed list in redis::" + list.get(i));
        }

        System.out.println();

        Set<String> list2 = jedis.keys("*");
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            String k = it.next();

            System.out.println("List of stored keys:: " + k);
        }
    }
}
