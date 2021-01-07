package com.example.demo.services;

import com.example.demo.models.UrlAlias;
import com.example.demo.models.UrlAliasDTO;
import com.example.demo.repository.UrlAliasRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AllServicesImp implements AllServices{
  UrlAliasRepository urlAliasRepository;

  public AllServicesImp(UrlAliasRepository urlAliasRepository) {
    this.urlAliasRepository = urlAliasRepository;
  }

  @Override
  public List<UrlAlias> getAllAliases() {
    return urlAliasRepository.findAll();
  }

  @Override
  public UrlAlias getAliasById(Long id) {
    return urlAliasRepository.getOne(id);
  }

  @Override
  public UrlAlias getAliasByAlias(String alias) {
    return urlAliasRepository.getAliasByAlias(alias);
  }

  @Override
  public UrlAlias tryToSaveNewAlias(UrlAlias alias) {
    UrlAlias newAlias = urlAliasRepository.getAliasByAlias(alias.getAlias());
    if(newAlias != null) {
      return null; //meaning there is already match in database ->no new Alias is created
    }
    newAlias=alias;
    newAlias.setSecretCode(generateSecretCode().toString());
    urlAliasRepository.save(newAlias);
    return newAlias;
  }

  private Integer generateSecretCode() {
    Integer randomNumber = (int) (Math.random()*9000 + 1000);
    return randomNumber;
  }

  @Override
  public Boolean checkExistenceOfAlias(String alias) {
    UrlAlias existingAlias = urlAliasRepository.getAliasByAlias(alias);
    if(existingAlias == null) {
      return false;
    }
    existingAlias.setHitCount(existingAlias.getHitCount()+1);
    urlAliasRepository.save(existingAlias);
    return true;
  }

  @Override
  public List<UrlAliasDTO> returnLinks() {
    List<UrlAlias>allAliases = urlAliasRepository.findAll();
    List<UrlAliasDTO>allDTOs = new ArrayList<>();
    for(UrlAlias alias : allAliases){
      allDTOs.add(new UrlAliasDTO(alias.getId(),alias.getUrl(),alias.getAlias(),alias.getHitCount()));
    }
    return allDTOs;
  }

  @Override
  public void deleteAlias(UrlAlias aliasToBeDeleted) {
    urlAliasRepository.delete(aliasToBeDeleted);
  }
}
