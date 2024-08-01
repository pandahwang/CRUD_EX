package com.panda.CRUD.CRUD_EX.repository;

import com.panda.CRUD.CRUD_EX.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
