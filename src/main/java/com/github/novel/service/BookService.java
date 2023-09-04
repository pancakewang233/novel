package com.github.novel.service;

import com.github.novel.core.common.resp.RestResp;
import com.github.novel.dto.resp.BookCategoryRespDto;

import java.util.List;

/**
 * @author 83443
 */
public interface BookService {

    /**
     * 小说目录列表查询接口
     * */
    RestResp<List<BookCategoryRespDto>> listCategory(Integer workDirection);
}
