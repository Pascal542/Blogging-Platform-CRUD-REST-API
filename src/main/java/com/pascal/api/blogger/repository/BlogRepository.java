package com.pascal.api.blogger.repository;

import com.pascal.api.blogger.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT * FROM blog_posts a WHERE a.tags LIKE %:tag%", nativeQuery = true)
    Page<Blog> findByTag(@Param("tag") String tag, Pageable pageable);
}