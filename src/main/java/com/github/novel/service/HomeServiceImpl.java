package com.github.novel.service;

import com.github.novel.core.common.resp.RestResp;
import com.github.novel.manager.HomeBookCacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 首页模块 服务实现类
 */
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeBookCacheManager homeBookCacheManager;

    @Override
    public RestResp<List<HomeBookRespDto>> listHomeBooks() {
        return RestResp.ok(homeBookCacheManager.listHomeBooks());
    }
}
