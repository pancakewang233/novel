package com.github.novel.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.novel.dao.entity.BookInfo;
import com.github.novel.dto.req.BookSearchReqDto;
import com.github.novel.dto.resp.BookInfoRespDto;

import java.util.List;

/**
 * @author 83443
 */
public interface BookInfoMapper extends BaseMapper<BookInfo> {
    /**
     * 小说搜索
     * @param page mybatis-plus 分页对象
     * @param condition 搜索条件
     * @return 返回结果
     * */
    List<BookInfo> searchBooks(IPage<BookInfoRespDto> page, BookSearchReqDto condition);
}
