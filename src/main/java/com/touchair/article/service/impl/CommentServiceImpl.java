package com.touchair.article.service.impl;

import com.touchair.article.dao.CommentRepository;
import com.touchair.article.po.Comment;
import com.touchair.article.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: bin.wang
 * @date: 2020/9/1 09:57
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentRepository commentRepository;

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<Comment> findCommentList() {
        return commentRepository.findAll();
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(String id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment findCommentById(String id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Page<Comment> findCommentListByParentid(String parentid, int page, int size) {
        return commentRepository.findByParentid(parentid, PageRequest.of(page-1, size));
    }

    @Override
    public void updateContentLikenum(String id) {
        //查询条件
        Query query = Query.query(Criteria.where("_id").is(id));
        //更新对象
        Update update=new Update();
        //局部更新，相当于$set
        // update.set(key,value)
        // 递增$inc
        // update.inc("likenum",1)
        update.inc("likenum");
        //参数1：查询对象
        // 参数2：更新对象
        // 参数3：集合的名字或实体类的类型Comment.class
        mongoTemplate.updateFirst(query, update, Comment.class);
    }
}
