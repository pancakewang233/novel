package com.github.novel.service;

import com.github.novel.core.common.resp.RestResp;
import com.github.novel.dto.resp.BookCategoryRespDto;

import java.util.List;

/**
 * @author 83443
 */
public interface BookService {

    /**
     * @return 小说分类列表查询接口
     * */
    RestResp<List<BookCategoryRespDto>> listCategory(Integer workDirection);
}
