package com.lhl.utils.Redis;

import com.lhl.utils.SerializeUtil;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * redis的核心
 */
public class RedisCache implements Cache {
    /*private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private static JedisConnectionFactory jedisConnectionFactory;

    private final String id;
    *//**
     * The {@code ReadWriteLock}.
     *//*
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("缓存ID不能为空");
        }
        logger.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }
    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }

    *//**
     * 获取缓存对象的唯一标准
     * *//*
    @Override
    public String getId() {
        return this.id;
    }

    *//**
     * 把key/value保存到缓存对象中
     *//*
    @Override
    public void putObject(Object key, Object value) {
        JedisConnection jedisConnection = null;
        try {
            //操作readis进行保存
            jedisConnection =jedisConnectionFactory.getConnection();
            //创建一个序列化工具
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            // 创建连接,保存key的value
            jedisConnection.set(serializer.serialize(key.toString()),serializer.serialize(value));
        }catch (JedisConnectionException e){
            e.printStackTrace();
        }finally {
            if (jedisConnection != null){
                jedisConnection.close();
            }
        }
    }

    *//**
     * 根据Key从缓存对象中获取对象
     *//*
    @Override
    public Object getObject(Object key) {
        Object result = null;
        JedisConnection jedisConnection = null;
        try {
            // 建立连接
            jedisConnection =jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer= new JdkSerializationRedisSerializer();
            byte[] bytes = jedisConnection.get(serializer.serialize(key));
            // 1. 将key序列化
            // 2. 通过connection获取序列化的value
            // 3. 将序列化的value反序列化
            result = serializer.deserialize(bytes);
            *//**
             * 序列化的是数据
             * 不会序列化类结构
             * 但会序列化关系(数据对应的类结构)
             *//*
        }catch (JedisConnectionException e){
            e.printStackTrace();
        }finally {
            if (jedisConnection != null){
                jedisConnection.close();
            }
        }
        return result;
    }

    *//**
     * 不是需要实现的方法,没有被核心框架调用
     * 方法作用: 根据key移除对应的value
     *//*
    @Override
    public Object removeObject(Object key) {
        Object result = null;
        JedisConnection jedisConnection = null;
        try {
            // 建立连接
            jedisConnection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer= new JdkSerializationRedisSerializer();
            // 移除保存到的值
            result = jedisConnection.expire(serializer.serialize(key),0);
        }catch (JedisConnectionException e){
            e.printStackTrace();
        }finally {
            if (jedisConnection != null){
                jedisConnection.close();
            }
        }
        return result;
    }

    *//**
     * 清除缓存(操作影响性能,效率低,不建议经常清除)
     * *//*
    @Override
    public void clear() {
        JedisConnection jedisConnection = null;
        try {
            jedisConnection =jedisConnectionFactory.getConnection();
            // 清除缓存
            jedisConnection.flushDb();
            // 清除设置
            jedisConnection.flushAll();
        }catch (JedisConnectionException e){
            e.printStackTrace();
        }finally {
            if (jedisConnection != null){
                jedisConnection.close();
            }
        }
    }

    *//**
     * 获取缓存对象中存取的key/value的数量
     *
     *//*
    @Override
    public int getSize() {
        Integer count = 0;
        JedisConnection jedisConnection = null;
        try {
            jedisConnection =jedisConnectionFactory.getConnection();
            count = Integer.valueOf(jedisConnection.dbSize().toString());
        }catch (JedisConnectionException e){
            e.printStackTrace();
        }finally {
            if (jedisConnection != null){
                jedisConnection.close();
            }
        }
        return count;
    }
    *//**
     * 获取读写锁
     * 从mybatis的3.2.6版本,这个方法不再被框架核心调用
     * 所有需要的锁,都必须由缓存供应商来提供
     * *//*
    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }*/
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;

    }

    public String getId() {
        return this.id;
    }

    public void putObject(Object key, Object value) {
        JedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()),
                SerializeUtil.serialize(value));

    }

    public Object getObject(Object key) {
        Object value = SerializeUtil.unserialize(JedisUtil.getJedis().get( SerializeUtil.serialize(key)));
        return value;

    }

    public Object removeObject(Object key) {
        return JedisUtil.getJedis().expire(
                SerializeUtil.serialize(key.toString()), 0);

    }

    public void clear() {
        JedisUtil.getJedis().flushDB();
    }

    public int getSize() {
        return Integer.valueOf(JedisUtil.getJedis().dbSize().toString());
    }

    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
