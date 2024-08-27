package com.pascal.api.blogger.controller;

import com.pascal.api.blogger.entity.Blog;
import com.pascal.api.blogger.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    // GET
    @GetMapping("/blogs")
    public List<Blog> getBlogs(@RequestParam(required = false) String tag) {
        return blogService.getAllBlogs(tag);
    }

    @GetMapping("blogs/{id}")
    public Optional<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    // POST
    @PostMapping("blogs")
    public ResponseEntity<String> saveBlog(@Valid @RequestBody Blog blog, BindingResult result) {
        return blogService.saveBlog(blog, result);
    }

    @PostMapping("blogs/{id}")
    public ResponseEntity<String> updateBlog(@Valid @RequestBody Blog blog, BindingResult result, @PathVariable Long id) {
       return blogService.updateBlog(blog, result, id);
    }

    // DELETE
    @DeleteMapping("blogs/{id}")
    public ResponseEntity<String> deleteBlogById(@PathVariable Long id) {
        return blogService.deleteBlogById(id);
    }










}
