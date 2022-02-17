package me.dyatkokg.demo.repo;

import me.dyatkokg.demo.entity.Resume;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ResumeRepo extends PagingAndSortingRepository<Resume,String> {

}
