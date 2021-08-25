package com.search.elastic.resource;

import com.search.elastic.entity.Resume;
import com.search.elastic.repository.ResumeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

  @Autowired
  ResumeRepository resumeRepository;

  @GetMapping(value = "/name/{text}")
  public List<Resume> searchName(@PathVariable final String text) {
    return resumeRepository.findByName(text);
  }


  @GetMapping(value = "/salary/{salary}")
  public List<Resume> searchSalary(@PathVariable final Long salary) {
    return resumeRepository.findBySalary(salary);
  }


  @GetMapping(value = "/all")
  public List<Resume> searchAll() {
    List<Resume> usersList = new ArrayList<>();
    Iterable<Resume> users = resumeRepository.findByName("Adam");
    users.forEach(usersList::add);
    return usersList;
  }
}
