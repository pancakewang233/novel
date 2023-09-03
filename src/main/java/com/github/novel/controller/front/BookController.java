package com.github.novel.controller.front;

import com.github.novel.core.common.constant.ApiRouterConsts;
import com.github.novel.core.common.resp.RestResp;
import com.github.novel.dto.resp.BookCategoryRespDto;
import com.github.novel.service.BookService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 83443
 * API_FRONT_BOOK_URL_PREFIX 这个统一的前缀是 /api/front/book
 */

@Tag(name = "BookController", description = "前台门户-小说模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_BOOK_URL_PREFIX)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("category/list")
    public RestResp<List<BookCategoryRespDto>> listCategory(
            @Parameter(description = "作品方向", required = true) Integer workDirection){
        return bookService.listCategory(workDirection);
    }
}
