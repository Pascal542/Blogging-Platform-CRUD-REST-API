package com.pascal.api.blogger.controller;

import com.pascal.api.blogger.entity.Blog;
import com.pascal.api.blogger.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("blogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("blogs/{id}")
    public Optional<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping("blogs")
    public String  saveBlog(@RequestBody Blog blog) {
        blogService.saveOrUpdateBlog(blog);
        return "El blog fue creado exitosamente!!";
    }

    @PostMapping("blogs/{id}")
    public String  updateBlog(@RequestBody Blog blog, @PathVariable Long id) {
        blog.setId(id);
        blogService.saveOrUpdateBlog(blog);
        return "El blog con id: " + id + " fue modificado exitosamente!!";
    }

    @DeleteMapping("blogs/{id}")
    public String deleteBlogById(@PathVariable Long id) {
        blogService.deleteBlogById(id);
        return "El blog con id: " + id + " fue eliminado exitosamente!!";
    }










}
