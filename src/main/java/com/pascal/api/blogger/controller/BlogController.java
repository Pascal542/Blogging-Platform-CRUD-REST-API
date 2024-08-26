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


    // GETS
    @GetMapping("/blogs")
    public List<Blog> getBlogs(@RequestParam(required = false) String tag) {
        if (tag != null && !tag.isEmpty()) {
            return blogService.getBlogsByTag(tag);
        } else {
            return blogService.getAllBlogs();
        }
    }

    @GetMapping("blogs/{id}")
    public Optional<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }


    // POSTS
    @PostMapping("blogs")
    public ResponseEntity<String> saveBlog(@Valid @RequestBody Blog blog, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    Objects.requireNonNull(result.getFieldError()).getDefaultMessage(),
                    HttpStatus.BAD_REQUEST);
        }
        blogService.saveOrUpdateBlog(blog);
        return new ResponseEntity<>("El blog fue creado exitosamente", HttpStatus.CREATED);
    }

    @PostMapping("blogs/{id}")
    public ResponseEntity<String> updateBlog(@Valid @RequestBody Blog blog, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    Objects.requireNonNull(result.getFieldError()).getDefaultMessage(),
                    HttpStatus.BAD_REQUEST);
        }

        if (blogService.getBlogById(id).isEmpty()) {
            return new ResponseEntity<>("El blog con id: " + id + " no existe", HttpStatus.NOT_FOUND);
        }

        blog.setId(id);
        blogService.saveOrUpdateBlog(blog);
        return new ResponseEntity<>("El blog fue modificado exitosamente", HttpStatus.OK);
    }


    // DELETE
    @DeleteMapping("blogs/{id}")
    public ResponseEntity<String> deleteBlogById(@PathVariable Long id) {
        if (blogService.getBlogById(id).isEmpty()) {
            return new ResponseEntity<>("El blog con id: " + id + " no existe", HttpStatus.NOT_FOUND);
        }
        blogService.deleteBlogById(id);
        return new ResponseEntity<>("El blog con id: " + id + " fue eliminado exitosamente", HttpStatus.OK);
    }










}
