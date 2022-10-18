package com.example.basicCaching.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.config.MaxSizePolicy;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

    @Bean
    public Config hazelCastConfig(){
        Config config = new Config();
        MapConfig resourceCache = new MapConfig();
        resourceCache.setTimeToLiveSeconds(2000);
        resourceCache.setEvictionConfig(new EvictionConfig().setEvictionPolicy(EvictionPolicy.LFU).setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE));
        config.getMapConfigs().put("books", resourceCache);
        return config;

    }
}
