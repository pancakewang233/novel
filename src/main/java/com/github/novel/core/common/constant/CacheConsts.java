package com.github.novel.core.common.constant;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 缓存相关常量
 * @author 83443
 */
public class CacheConsts {

    /**
     * 本项目 Redis 缓存前缀
     * */
    public static final String REDIS_CACHE_PREFIX = "Cache::Novel::";


    /**
     * Caffeine 缓存管理器
     * */
    public static final String CAFFEINE_CACHE_MANAGER = "caffeineCacheManager";

    /**
     * Redis 缓存管理器
     * */
    public static final String REDIS_CACHE_MANAGER = "redisCacheManager";

    /**
     * 首页小说推荐缓存
     * */
    public static final String HOME_BOOK_CACHE_NAME = "homeBookCache";

    /**
     * 首页小说目录缓存
     **/
    public static final String BOOK_CATEGORY_CACHE_NAME = "bookCategoryCache";

    /**
     * 首页友情链接缓存
     * */
    public static final String HOME_FRIEND_LINK_CACHE_NAME = "homeFriendLinkCache";

    /**
     * 缓存配置常量
     */
    public enum CacheEnum {

        HOME_BOOK_CACHE(1,HOME_BOOK_CACHE_NAME,0,1),
        HOME_FRIEND_LINK_CACHE(2,HOME_FRIEND_LINK_CACHE_NAME,1000,1),
        BOOK_CATEGORY_CACHE(1, BOOK_CATEGORY_CACHE_NAME, 0, 1);

        /**
         * 缓存类型 0-本地 1-本地和远程 2-远程
         */
        private int type;
        /**
         * 缓存的名字
         */
        private String name;
        /**
         * 失效时间（秒） 0-永不失效
         */
        private int ttl;
        /**
         * 最大容量
         */
        private int maxSize;

        CacheEnum(int type, String name, int ttl, int maxSize) {
            this.type = type;
            this.name = name;
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        public boolean isLocal() {
            return type <= 1;
        }

        public boolean isRemote() {
            return type >= 1;
        }

        public String getName() {
            return name;
        }

        public int getTtl() {
            return ttl;
        }

        public int getMaxSize() {
            return maxSize;
        }

    }

    /**
     * Caffeine 缓存管理器
     */
    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        List<CaffeineCache> caches = new ArrayList<>(CacheConsts.CacheEnum.values().length);
        for (CacheConsts.CacheEnum c : CacheConsts.CacheEnum.values()) {
            if (c.isLocal()) {
                Caffeine<Object, Object> caffeine = Caffeine.newBuilder().recordStats().maximumSize(c.getMaxSize());
                if (c.getTtl() > 0) {
                    caffeine.expireAfterWrite(Duration.ofSeconds(c.getTtl()));
                }
                caches.add(new CaffeineCache(c.getName(), caffeine.build()));
            }
        }

        cacheManager.setCaches(caches);
        return cacheManager;
    }

}
