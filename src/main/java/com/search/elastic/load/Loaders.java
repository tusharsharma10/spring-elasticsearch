package com.search.elastic.load;

import com.search.elastic.entity.Resume;
import com.search.elastic.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

  @Autowired
  ElasticsearchOperations operations;

  @Autowired
  ResumeRepository resumeRepository;

  @PostConstruct
  @Transactional
  public void loadAll(){

   // operations.save(Resume.class);
    System.out.println("Loading Data");
    resumeRepository.saveAll(getData());
    System.out.printf("Loading Completed");

  }

  private List<Resume> getData() {
    List<Resume> users = new ArrayList<>();
    users.add(new Resume("Adam", "Accounting", 12000));
    users.add(new Resume("Jack", "Finance", 22000));
    users.add(new Resume("Trueman", "Accounting", 12000));
    return users;
  }
}