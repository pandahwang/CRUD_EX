package com.panda.CRUD.CRUD_EX.repository;

import com.panda.CRUD.CRUD_EX.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
