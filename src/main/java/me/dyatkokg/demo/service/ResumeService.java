package me.dyatkokg.demo.service;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.demo.entity.PersonalData;
import me.dyatkokg.demo.entity.Resume;
import me.dyatkokg.demo.repo.ResumeRepo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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


    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event){
        Resume resume = new Resume();
        PersonalData personalData = new PersonalData();
        personalData.setFirstName("karisha");
        personalData.setLastName("dyatko");
        personalData.setBirthday(LocalDate.of(1997,8,1));
        resume.setData(personalData);
        resumeRepo.save(resume);
    }
}
