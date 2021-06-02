package com.example.blog.repository;

import com.example.blog.entities.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {

    Iterable<Article> findAllByOrderByCreatedAtDesc();

    Article findByPostSlug(String postSlug);
}
