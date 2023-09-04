package com.github.novel.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.novel.core.common.constant.CacheConsts;
import com.github.novel.core.common.constant.DatabaseConsts;
import com.github.novel.dao.entity.BookCategory;
import com.github.novel.dao.entity.HomeBook;
import com.github.novel.dao.mapper.BookCategoryMapper;
import com.github.novel.dto.resp.BookCategoryRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 83443
 */
@Component
@RequiredArgsConstructor
public class BookCategoryCacheManager {
    private final BookCategoryMapper bookCategoryMapper;

    /**
      *  查询首页小说目录，并放入缓存中
    * */
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER
            , value = CacheConsts.BOOK_CATEGORY_CACHE_NAME)
    public List<BookCategoryRespDto> listCategory(Integer workDirection){
        QueryWrapper<BookCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.BookCategoryTable.COLUMN_WORK_DIRECTION, workDirection);
        return bookCategoryMapper.selectList(queryWrapper).stream().map(v ->
            BookCategoryRespDto.builder()
                    .id(v.getId())
                    .name(v.getName())
                    .build()).toList();
    }
}
