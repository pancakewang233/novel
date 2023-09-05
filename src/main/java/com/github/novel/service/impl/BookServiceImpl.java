package com.github.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.novel.core.common.constant.DatabaseConsts;
import com.github.novel.core.common.resp.RestResp;
import com.github.novel.dao.entity.BookCategory;
import com.github.novel.dao.mapper.BookCategoryMapper;
import com.github.novel.dto.resp.BookCategoryRespDto;
import com.github.novel.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 83443
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookCategoryMapper bookCategoryMapper;
    @Override
    public RestResp<List<BookCategoryRespDto>> listCategory(Integer workDirection) {
        QueryWrapper<BookCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.BookCategoryTable.COLUMN_WORK_DIRECTION, workDirection);
        return RestResp.ok(bookCategoryMapper.selectList(queryWrapper).stream().map(v ->
                BookCategoryRespDto.builder()
                        .id(v.getId())
                        .name(v.getName())
                        .build()).toList());
    }
}
