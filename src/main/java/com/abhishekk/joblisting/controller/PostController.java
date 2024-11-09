package com.abhishekk.joblisting.controller;
import com.abhishekk.joblisting.repository.PostRepository;
import com.abhishekk.joblisting.model.Post;
import com.abhishekk.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository sRepo;


    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @GetMapping("/Posts/{text}")
    public List<Post> search(@PathVariable String text){
        return sRepo.findByText(text);
    }



    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

}