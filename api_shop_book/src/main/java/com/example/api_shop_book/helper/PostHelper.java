//package com.example.api_shop_book.helper;
//
//import com.demo.demo2.mapper.PostMapper;
//import com.demo.demo2.models.Post;
//import com.demo.demo2.payload.response.PostResponse;
//import com.demo.demo2.security.services.PostService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class PostHelper {
//    private final PostService postService;
//    private final UserDetailsService userDetailsService;
//
//    public ResponseEntity<Post> getById(Integer id) {
//        Post post = postService.getById(id);
//        if (post != null) {
//            return ResponseEntity.ok(post);
//        }
//        return null;
//    }
//
//    public ResponseEntity<List<Post>> getAllPost() {
//        List<Post> post = postService.findAllPost();
//        if (post != null) {
//            System.out.println(true);
//            return ResponseEntity.ok(post);
//        }
//        return null;
//    }
//
//    public ResponseEntity<?> getAllPostDetail() {
//        List<Post> posts = postService.getPostResponse();
////        List<PostResponse> resp = new ArrayList<>();
////        for (int i = 0; i < posts.size(); i++) {
////            Post post = posts.get(i);
////            PostResponse postResp = PostMapper.toPostResp(post);
////            resp.add(postResp);
////        }
//        List<PostResponse> resp = posts.stream()
//                .map(post -> PostMapper.toPostResp(post))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(resp);
//    }
//
////    public ResponseEntity<?> save(PostRequest postRequest) {
////        Post post = null;
////        Integer id = postRequest.getId();
////        String username = post.getUser().getUsername();
////        if (id != null && (postService.getById(id) != null)) {
////            post = postService.getById(id);
////        }
////        post.setUser(userDetailsService.loadUserByUsername(username));
////        return ResponseEntity.ok(post);
////    }
//
//}
