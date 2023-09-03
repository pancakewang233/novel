package com.github.novel.service.impl;

import com.github.novel.core.common.resp.RestResp;
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

    @Override
    public RestResp<List<BookCategoryRespDto>> listCategory(Integer workDirection) {
        System.out.println("------- what here is the list --------");
        return null;
    }
}
