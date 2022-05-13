//package com.example.api_shop_book.security.services;
//
//
//import com.demo.demo2.models.Post;
//import com.demo.demo2.repository.BookRepository;
//import com.demo.demo2.repository.PostRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class PostService {
//    private final PostRepository postRepository;
//    private final BookRepository bookRepository;
////    private final PostResponse postResponse;
//    public Post addPost(Post post) {
//        return postRepository.save(post);
//    }
//
//    public List<Post> findAllPost() {
//
//        return postRepository.findAll();
//    }
//    public List<Post> getPostResponse(){
//        List<Post> posts = postRepository.findAll();
//       return posts;
//    }
//    public Post getById(Integer id) {
//        Optional<Post> optional = postRepository.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        }
//        return null;
//    }
////    public List<Post> getPostDetail(String username,String date,String title,String img,String name,String description){
////        return postRepository.getPostDetail(username,date,title,img,name,description);
////    }
//
//    public Post updatePost(Post post) {
//        return postRepository.save(post);
//    }
//
//    public void deletePost(Integer id) {
//        postRepository.deletePostById(id);
//    }
//}
