package com.touchair.article.dao;

import com.touchair.article.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 评论持久层的接口
 *
 * @author: bin.wang
 * @date: 2020/9/1 09:52
 */
public interface CommentRepository extends MongoRepository<Comment,String> {
    /**
     * 自定义接口 根据父级id 返回分页结果
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
