package com.touchair.article.service;

import com.touchair.article.po.Comment;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 文章评论的service接口
 *
 * @author: bin.wang
 * @date: 2020/9/1 09:57
 */
public interface CommentService {


    /**
     * 查询所有评论
     * @return
     */
    List<Comment> findCommentList();

    /**
     * 保存评论
     *如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
     * @param comment
     */
    void saveComment(Comment comment);

    /**
     * 更新评论
     *
     * @param comment
     */
    void updateComment(Comment comment);

    /**
     * 根据id删除评论
     *
     * @param id
     */
    void deleteCommentById(String id);

    /**
     * 根据id查询评论
     *
     * @param id
     * @return
     */
    Comment findCommentById(String id);

    /**
     * 根据父级id 获取分页结果
     *
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    Page<Comment> findCommentListByParentid(String parentid, int page, int size);

    /**
     * 点赞数增加
     *
     * @param id
     */
    void updateContentLikenum(String id);

}
