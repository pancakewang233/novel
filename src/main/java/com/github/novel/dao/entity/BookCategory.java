package com.github.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 83443
 */
@Data
@TableName("book_category")
public class BookCategory {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Integer workDirection;
    private String name;
    private Integer sort;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "BookCategory{" +
            "id=" + id +
            ", workDirection=" + workDirection +
            ", sort=" + sort +
            ", name=" + name +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            "}";
    }
}
