package me.dyatkokg.demo.service;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.demo.dto.ResumeDTO;
import me.dyatkokg.demo.exceptions.FieldEmptiesException;
import me.dyatkokg.demo.exceptions.ResumeNotFoundException;
import me.dyatkokg.demo.mapper.ResumeMapper;
import me.dyatkokg.demo.repo.ResumeRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepo resumeRepo;

    private final ResumeMapper mapper;


    public ResponseEntity<ResumeDTO> create(ResumeDTO resume) {
        if (Objects.nonNull(resume.getData()) && Objects.nonNull(resume.getContacts())) {
            return ResponseEntity.ok(mapper.toDTO(resumeRepo.save(mapper.toEntity(resume))));
        } else throw new FieldEmptiesException();
    }

    public ResponseEntity<ResumeDTO> getById(String id) {
        return resumeRepo.findById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResumeNotFoundException(id));
    }

    public ResponseEntity<ResumeDTO> deleteById(String id) {
        ResumeDTO deleted = resumeRepo.findById(id).map(mapper::toDTO).orElse(null);
        if (deleted == null) {
            throw new ResumeNotFoundException();
        } else
            resumeRepo.deleteById(id);
        return ResponseEntity.ok(deleted);
    }

    public ResponseEntity<ResumeDTO> update(ResumeDTO resume) {
        if (resumeRepo.existsById(resume.getId())) {
            return ResponseEntity.ok(mapper.toDTO(resumeRepo.save(mapper.toEntity(resume))));
        } else throw new ResumeNotFoundException();
    }

    public Page<ResumeDTO> findAll(int size, int page) {
        return resumeRepo.findAll(PageRequest.of(size, page)).map(mapper::toDTO);
    }

}
