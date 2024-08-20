package com.panda.CRUD.CRUD_EX.Article.repository;

import com.panda.CRUD.CRUD_EX.Article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
