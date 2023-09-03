package com.github.novel.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
* Serializable是http://java.io包中定义的、用于实现Java类的序列化操作而提供的一个语义级别的接口。
* Serializable序列化接口没有任何方法或者字段，只是用于标识可序列化的语义。
* 实现了Serializable接口的类可以被ObjectOutputStream转换为字节流，
* 同时也可以通过ObjectInputStream再将其解析为对象。
* */

/**
 * @author 83443
 */

@TableName("home_book")
@Data
public class HomeBook implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer type;
    private Integer sort;
    private Long bookId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "HomeBook{" +
                "id=" + id +
                ", type=" + type +
                ", sort=" + sort +
                ", bookId=" + bookId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
