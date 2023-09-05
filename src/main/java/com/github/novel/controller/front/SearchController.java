package com.github.novel.controller.front;

import com.github.novel.core.common.constant.ApiRouterConsts;
import com.github.novel.core.common.resp.PageRespDto;
import com.github.novel.core.common.resp.RestResp;
import com.github.novel.dto.req.BookSearchReqDto;
import com.github.novel.dto.resp.BookInfoRespDto;
import com.github.novel.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 83443
 * api 路径前缀 front
 */
@Tag(name = "SearchController", description = "前台门户-搜索模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_URL_PREFIX)
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;
    @Operation(summary = "小说搜索接口")
    @GetMapping("search/books")
    public RestResp<PageRespDto<BookInfoRespDto>> searchBooks(
            @Parameter BookSearchReqDto condition
    ){
        return searchService.searchBooks(condition);
    }
}
