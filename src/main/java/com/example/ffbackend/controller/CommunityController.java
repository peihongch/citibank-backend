package com.example.ffbackend.controller;

import com.example.ffbackend.vo.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community")
public class CommunityController {
    @GetMapping(value={"/post/myPosts"})
    public ResponseBean<PostVo[]> getMyPosts(@RequestBody String userId){
        System.out.println(userId);
        return null;
    }

    @GetMapping(value={"/post/view"})
    public ResponseBean<PostViewVO> getView(@RequestBody String postId){
        System.out.println(postId);
        return null;
    }

    @GetMapping(value={"/post/search"})
    public ResponseBean<PostSearchVo> search(@RequestBody String keyword, @RequestBody String usrId){
        System.out.println(keyword);
        System.out.println(usrId);
        return null;
    }

    @GetMapping(value={"/post/issue"})
    public ResponseBean<Object> postIssue(@RequestBody IssueVo issueVo){
        return null;
    }

    @GetMapping(value={"/tag/hotTags"})
    public ResponseBean<TagVo[]> getHotTags(){
        return null;
    }

    @GetMapping(value={"/post/hotPosts"})
    public ResponseBean<HotPostVo[]> getHotPosts(@RequestBody String userId, @RequestBody int page, @RequestBody int num){
        return null;
    }

    @GetMapping(value={"/post/recentPosts"})
    public ResponseBean<HotPostVo[]> getRecentPosts(@RequestBody String userId, @RequestBody int page, @RequestBody int num){
        return null;
    }

    @GetMapping(value={"/comment/commentList"})
    public ResponseBean<CommentVo[]> getCommentList(@RequestBody String[] postId){
        return null;
    }

    @PostMapping(value={"/comment/send"})
    public ResponseBean<CommentVo[]> makeComment(@RequestBody String userid, @RequestBody String postid, @RequestBody String comment){
        return null;
    }
}
