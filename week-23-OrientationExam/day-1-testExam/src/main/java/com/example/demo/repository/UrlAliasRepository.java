package com.example.demo.repository;

import com.example.demo.models.UrlAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlAliasRepository extends JpaRepository<UrlAlias, Long> {
  @Query("select a from UrlAlias a where a.alias = ?1")
  UrlAlias getAliasByAlias(String alias);
}
