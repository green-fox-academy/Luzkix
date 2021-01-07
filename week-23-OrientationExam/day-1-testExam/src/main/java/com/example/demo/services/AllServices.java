package com.example.demo.services;

import com.example.demo.models.UrlAlias;
import com.example.demo.models.UrlAliasDTO;
import java.util.List;

public interface AllServices {
  List<UrlAlias> getAllAliases();
  UrlAlias getAliasById(Long id);
  UrlAlias getAliasByAlias(String alias);

  UrlAlias tryToSaveNewAlias(UrlAlias alias);

  Boolean checkExistenceOfAlias(String alias);

  List<UrlAliasDTO> returnLinks();

  void deleteAlias(UrlAlias aliasToBeDeleted);
}
