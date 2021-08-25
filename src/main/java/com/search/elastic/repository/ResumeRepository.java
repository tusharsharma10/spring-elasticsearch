package com.search.elastic.repository;

import com.search.elastic.entity.Resume;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResumeRepository extends ElasticsearchRepository<Resume, String> {
  List<Resume> findByName(String text);
  List<Resume> findBySalary(Long salary);
}
