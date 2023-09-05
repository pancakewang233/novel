package com.github.novel.service;

import com.github.novel.core.common.resp.PageRespDto;
import com.github.novel.core.common.resp.RestResp;
import com.github.novel.dto.req.BookSearchReqDto;
import com.github.novel.dto.resp.BookInfoRespDto;

import java.util.List;

/**
 * @author 83443
 *
 **/
public interface SearchService {
    RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition);
}
