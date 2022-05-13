//package com.example.api_shop_book.mapper;
//
//
//import com.demo.demo2.models.Post;
//import com.demo.demo2.payload.request.PostRequest;
//import com.demo.demo2.payload.response.PostResponse;
//
//public class PostMapper {
//
//    public static PostResponse toPostResp (Post post){
//        PostResponse postResp = new PostResponse();
//
//        postResp.setId(post.getId());
//        postResp.setUsername(post.getUser().getUsername());
//        postResp.setContent(post.getContent());
//        postResp.setImg(post.getBook().getImage());
//        postResp.setBookName(post.getBook().getName());
//        postResp.setStatus(post.getBook().getStatus());
//        postResp.setDescription(post.getBook().getDescription());
//        postResp.setCategory(post.getBook().getCategory().getName());
//        postResp.setDate(post.getDate());
//        return postResp;
//    }
//    public static PostRequest toDto (Post post){
//        PostRequest postReq = new PostRequest();
//        postReq.setId(post.getId());
//        postReq.setUsername(post.getUser().getUsername());
//        postReq.setContent(post.getContent());
//        postReq.setImg(post.getBook().getImage());
//        postReq.setBookName(post.getBook().getName());
//        postReq.setStatus(post.getBook().getStatus());
//        postReq.setDescription(post.getBook().getDescription());
//        postReq.setCategory(post.getBook().getCategory().getName());
//        return postReq;
//    }
//}
