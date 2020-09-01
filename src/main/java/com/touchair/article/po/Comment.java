package com.touchair.article.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 文章评论实体类
 *
 * @author: bin.wang
 * @date: 2020/9/1 09:36
 */
//把一个java类声明为mongodb的文档，可以通过collection参数指定这个类对应的文档。
// @Document(collection="mongodb 对应 collection 名")
// 若未加 @Document ，该 bean save 到 mongo 的 comment collection
// 若添加 @Document ，则 save 到 comment collection

//可以省略，如果省略，则默认使用类名小写映射集合
@Document(collection="comment")
@Getter
@Setter
@ToString
//复合索引
@CompoundIndex( def = "{'userid': 1, 'nickname': -1}")
public class Comment implements Serializable {
    /**
     *   主键标识，该属性的值会自动对应mongodb的主键字段"_id"，如果该属性名就叫“id”,则该注解可以省略，否则必须写
     */
    @Id
    private String id;

    /**
     * 该属性对应mongodb的字段的名字，如果一致，则无需该注解
     * 吐槽内容
     */
    @Field("content")
    private String content;
    /**
     * 发布日期
     */
    private Date publishtime;
    /**
     * 发布人ID
     */
    @Indexed
    private String userid;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 评论的日期时间
     */
    private LocalDateTime createdatetime;
    /**
     * 点赞数
     */
    private Integer likenum;
    /**
     * 回复数
     */
    private Integer replynum;
    /**
     * 状态
     */
    private String state;
    /**
     * 上级ID
     */
    private String parentid;
    /**
     * 文章id
     */
    private String articleid;

}
