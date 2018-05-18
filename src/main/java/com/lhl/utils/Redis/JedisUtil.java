package com.lhl.utils.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis连接池类
 * */
public class JedisUtil {
    private static String ADDR = "127.0.0.1";
    private static int PORT = 6379;
    private static String AUTH = "123";

    private static int MAX_ACTIVE = 1024;

    private static int MAX_IDLE = 200;

    private static int MAX_WAIT = 10000;

    private static int TIMEOUT = 10000;

    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    static {
        try{
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config,ADDR,PORT,TIMEOUT,AUTH);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis(){
        Jedis jedis = null;
        try{
            if(jedisPool != null){
                 jedis = jedisPool.getResource();
                return jedis;
            }else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource(){
        /*if(jedis != null){
            jedisPool.returnResource(jedis);
        }*/
        jedisPool.getResource();
    }
}
