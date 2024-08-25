package com.pascal.api.blogger.service;

import com.pascal.api.blogger.entity.Blog;
import com.pascal.api.blogger.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public void saveOrUpdateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public void deleteBlogById(Long id) {
        blogRepository.deleteById(id);
    }
}
