package me.dyatkokg.demo.repo;

import me.dyatkokg.demo.entity.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ResumeRepo extends MongoRepository<Resume,String> {

}
