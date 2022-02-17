package me.dyatkokg.demo.service;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.demo.dto.ResumeDTO;
import me.dyatkokg.demo.exceptions.FieldEmptiesException;
import me.dyatkokg.demo.exceptions.ResumeNotFoundException;
import me.dyatkokg.demo.mapper.ResumeMapper;
import me.dyatkokg.demo.repo.ResumeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private  final ResumeRepo resumeRepo;

    private final ResumeMapper mapper;


    public ResponseEntity<ResumeDTO> create(ResumeDTO resume) {
        if(Objects.nonNull(resume.getData())&&Objects.nonNull(resume.getContacts())) {
            return ResponseEntity.ok(mapper.toDTO(resumeRepo.save(mapper.toEntity(resume)))) ;
        }else throw new FieldEmptiesException();
    }

    public ResponseEntity<ResumeDTO> getById(String id) {
        return resumeRepo.findById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(()->new ResumeNotFoundException(id));
    }

    public ResponseEntity<ResumeDTO> deleteById(String id) {
        ResumeDTO deleted = resumeRepo.findById(id).map(mapper::toDTO).orElse(null);
        if (deleted == null) {
            return ResponseEntity.noContent().build();
        } else
            resumeRepo.deleteById(id);
        return ResponseEntity.ok(deleted);
    }


    public ResponseEntity<ResumeDTO> update(ResumeDTO resume) {
        if (resumeRepo.existsById(resume.getId())) {
            return ResponseEntity.ok(mapper.toDTO(resumeRepo.save(mapper.toEntity(resume))));
        } else
            return ResponseEntity.notFound().build();
    }


//    @EventListener
//    public void onApplicationReady(ApplicationReadyEvent event){
//        Resume resume = new Resume();
//        PersonalData personalData = new PersonalData();
//        personalData.setFirstName("karisha");
//        personalData.setLastName("dyatko");
//        personalData.setBirthday(LocalDate.of(1997,8,1));
//        resume.setData(personalData);
//        resumeRepo.save(resume);
//    }

    public ResponseEntity<List<ResumeDTO>> findAll() {
        return ResponseEntity.ok(resumeRepo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }
}
