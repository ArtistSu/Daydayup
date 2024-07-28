package com.artists.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings(value = {"unchecked","rawtypes"})
@Component
public class RedisCache {
    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * Cache basic object: Integer, String, Entity
     * @param key cache key
     * @param value cache value
     * @param <T>
     */
    public <T> void setCacheObject(final String key, final T value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * Cache basic object: Integer, String, Entity
     * @param key cache key
     * @param value cache value
     * @param timeout time
     * @param timeUnit time unit
     * @param <T>
     */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,timeout,timeUnit);
    }

    /**
     * Set valid time
     * @param key Redis key
     * @param timeout Timeout
     * @param unit unit of time
     * @return true -> configure success, false -> configure failed
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit){
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * Get basic object in cache
     * @param key
     * @param <T>
     */
    public <T> T getCacheObject(final String key){
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * Delete an object
     * @param key
     * @return
     */
    public boolean deleteObject(final String key){
        return redisTemplate.delete(key);
    }

    /**
     * Delete multiple objects
     * @param collection
     * @return
     */
    public long deleteObject(final Collection collection){
        return redisTemplate.delete(collection);
    }

    /**
     * Cache List
     * @param key The key need to cache
     * @param dataList The data need to be cached
     * @return
     * @param <T>
     */
    public <T> long setCacheList(final String key, final List<T> dataList){
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0: count;
    }

    /**
     * Get the list in cache
     * @param key the key of list in cache
     * @return
     * @param <T>
     */
    public <T> List<T> getCacheList(final String key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * Cache set object
     * @param key the key of the set object in the cache
     * @param dataSet the data need to be put into cache
     * @return
     * @param <T>
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet){
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while(it.hasNext()){
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * Cache map
     * @param key the key of the map in the cache
     * @param dataMap the data of the map
     * @param <T>
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap){
        if(dataMap != null){
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * Get map in cache
     * @param key
     * @return
     * @param <T>
     */
    public <T> Map<String,T> getCacheMap(final String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * Put data into Hash
     * @param key Redis key
     * @param hkey Hash Key
     * @param value Value
     * @param <T>
     */
    public <T> void setCacheMapValue(final String key, final String hkey, final T value){
        redisTemplate.opsForHash().put(key,hkey,value);
    }

    /**
     * Get data in Hash
     * @param key Redis key
     * @param hKey Hash Key
     * @return The object in Hash
     * @param <T>
     */
    public <T> T getCacheMapValue(final String key, final String hKey){
        HashOperations<String,String,T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key,hKey);
    }

    /**
     * Delete data in Hash
     * @param key Redis key
     * @param hKey Hash Key Collection
     */
    public void delCacheMapValue(final String key, final String hKey){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(key,hKey);
    }

    /**
     * Get multiple data in Hash
     * @param key Redis Key
     * @param hkeys Hash key Collection
     * @return Hash Object Collection
     * @param <T>
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hkeys){
        return redisTemplate.opsForHash().multiGet(key,hkeys);
    }

    /**
     * Get a list of basic objecy in cache
     * @param pattern Prefix of string
     * @return Hash Object Collection
     */
    public Collection<String> keys(final String pattern){
        return redisTemplate.keys(pattern);
    }
}
