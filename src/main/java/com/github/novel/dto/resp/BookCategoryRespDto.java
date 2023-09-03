package com.github.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * @author 83443
 */
public class BookCategoryRespDto {
    @Schema(description = "作品方向;0-男频 1-女频")
    private Integer workDirection;
    @Schema(description = "类别名")
    private String name;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
