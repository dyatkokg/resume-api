package me.dyatkokg.demo.service;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.demo.entity.Resume;
import me.dyatkokg.demo.repo.ResumeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private  final ResumeRepo resumeRepo;

    public ResponseEntity<?> create(Resume resume) {
        return ResponseEntity.ok(resumeRepo.save(resume));
    }

    public ResponseEntity<?> getById(String id) {
        return resumeRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> deleteById(String id) {
        Resume deleted = resumeRepo.findById(id).orElse(null);
        if (deleted == null) {
            return ResponseEntity.noContent().build();
        } else
            resumeRepo.delete(deleted);
        return ResponseEntity.ok(deleted);
    }


    public ResponseEntity<?> update(Resume resume) {
        if (resumeRepo.existsById(resume.getId())) {
            return ResponseEntity.ok(resumeRepo.save(resume));
        } else
            return ResponseEntity.notFound().build();
    }

}
