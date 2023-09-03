package com.github.novel.service.impl;

import com.github.novel.core.common.resp.RestResp;
import com.github.novel.dto.resp.HomeBookRespDto;
import com.github.novel.manager.HomeBookCacheManager;
import com.github.novel.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 首页模块 服务实现类
 * @author 83443
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
