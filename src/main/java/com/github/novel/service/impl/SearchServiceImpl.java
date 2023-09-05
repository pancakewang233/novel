package com.github.novel.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.novel.core.common.resp.PageRespDto;
import com.github.novel.core.common.resp.RestResp;
import com.github.novel.dao.entity.BookInfo;
import com.github.novel.dao.mapper.BookInfoMapper;
import com.github.novel.dto.req.BookSearchReqDto;
import com.github.novel.dto.resp.BookInfoRespDto;
import com.github.novel.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 83443
 */
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final BookInfoMapper bookInfoMapper;

    @Override
    public RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition) {
        Page<BookInfoRespDto> page = new Page<>();
        page.setCurrent(condition.getPageNum());
        page.setSize(condition.getPageSize());
        List<BookInfo> bookInfos = bookInfoMapper.searchBooks(page, condition);
        return RestResp.ok(PageRespDto.of(condition.getPageNum(), condition.getPageSize(), page.getTotal(),
            bookInfos.stream().map(v -> BookInfoRespDto.builder()
                    .id(v.getId())
                    .bookName(v.getBookName())
                    .categoryId(v.getCategoryId())
                    .categoryName(v.getCategoryName())
                    .authorId(v.getAuthorId())
                    .authorName(v.getAuthorName())
                    .wordCount(v.getWordCount())
                    .lastChapterName(v.getLastChapterName())
                    .build()).toList()));
    }
}
