package com.touchair.arcticle;

import com.touchair.article.ArticleMain;
import com.touchair.article.po.Comment;
import com.touchair.article.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 评论业务类的测试类
 *
 * @author: bin.wang
 * @date: 2020/9/1 11:19
 */
//集成JUnit
@RunWith(SpringRunner.class)
//测试环境初始化
@SpringBootTest(classes = ArticleMain.class)
@Slf4j
public class CommentServiceTest {
    @Resource
    private CommentService commentService;

    /**
     * 测试获取集合所有文档记录
     */
    @Test
    public void testFindCommentList(){
         log.info(commentService.findCommentList().toString());
    }

    /**
     * 测试根据id获取文档记录
     */
    @Test
    public void testFindCommentById(){
        log.info(commentService.findCommentById("1").toString());
    }

    /**
     * 测试新增一个评论
     */
    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
        comment.setArticleid("100012");
        comment.setContent("带父级的测试数据4");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("10012");
        comment.setNickname("mongodb parentid test");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        comment.setParentid("3");
        commentService.saveComment(comment);
    }

    /**
     * 测试根据父级id返回分页结果
     */
    @Test
    public void testFindCommentListByParentid(){
        Page<Comment> commentListByParentid = commentService.findCommentListByParentid("3", 1, 2);
        log.info(commentListByParentid.getContent().toString());
        log.info(commentListByParentid.getTotalElements()+"");
        log.info(commentListByParentid.getTotalPages()+"");
    }

    /**
     * 测试点赞数＋1
     */
    @Test
    public  void testUpdateContentLikenum(){
        commentService.updateContentLikenum("1");
    }
}
