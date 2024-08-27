package com.pascal.api.blogger.service;

import com.pascal.api.blogger.entity.Blog;
import com.pascal.api.blogger.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }



    // GET ALL DATA MAIN METHOD
    // GET ALL DATA WITH TAG VALIDATION
    public Page<Blog> getAllBlogs(String tag, Pageable pageable) {
        if (tag != null && !tag.isEmpty()) {
            return getBlogsByTag(tag, pageable);
        } else {
            return blogRepository.findAll(pageable);
        }
    }

    // SAVE BLOG MAIN METHOD
    // WITH VALIDATION CHECK BY RESULT IF HAS ERRORS
    public ResponseEntity<String> saveBlog(Blog blog ,BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    Objects.requireNonNull(result.getFieldError()).getDefaultMessage(),
                    HttpStatus.BAD_REQUEST);
        }
        blogRepository.save(blog);
        return new ResponseEntity<>("El blog fue creado exitosamente", HttpStatus.CREATED);
    }

    // UPDATE BLOG MAIN METHOD
    // WITH VALIDATION CHECK BY RESULT IF HAS ERRORS
    // CHECK IF BLOG ID EXISTS
    public ResponseEntity<String> updateBlog(Blog blog, BindingResult result, Long id) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    Objects.requireNonNull(result.getFieldError()).getDefaultMessage(),
                    HttpStatus.BAD_REQUEST);
        }
        if (getBlogById(id).isEmpty()) {
            return new ResponseEntity<>("El blog con id: " + id + " no existe", HttpStatus.NOT_FOUND);
        }
        blog.setId(id);
        blogRepository.save(blog);
        return new ResponseEntity<>("El blog fue modificado exitosamente", HttpStatus.OK);
    }

    // DELETE BLOG BY ID
    public ResponseEntity<String> deleteBlogById(Long id) {
        if (getBlogById(id).isEmpty()) {
            return new ResponseEntity<>("El blog con id: " + id + " no existe", HttpStatus.NOT_FOUND);
        }
        blogRepository.deleteById(id);
        return new ResponseEntity<>("El blog con id: " + id + " fue eliminado exitosamente", HttpStatus.OK);
    }

    // GET BLOGS BY ID
    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    // GET BLOGS BY TAG
    public Page<Blog> getBlogsByTag(String tag, Pageable pageable) {
        return blogRepository.findByTag(tag, pageable);
    }
}
