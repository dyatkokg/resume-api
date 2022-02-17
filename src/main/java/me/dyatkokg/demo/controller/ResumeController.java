package me.dyatkokg.demo.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.demo.aspect.LoggableRequest;
import me.dyatkokg.demo.dto.ResumeDTO;
import me.dyatkokg.demo.service.ResumeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @LoggableRequest
    @PutMapping("create")
    public ResponseEntity<ResumeDTO> create(@RequestBody ResumeDTO resume) {
        return resumeService.create(resume);
    }

    @LoggableRequest
    @GetMapping("find-all")
    public Page<ResumeDTO> findAll(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                   @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return resumeService.findAll(page, size);
    }

    @LoggableRequest
    @GetMapping("{id}")
    public ResponseEntity<ResumeDTO> getById(@PathVariable("id") String id) {
        return resumeService.getById(id);
    }

    @LoggableRequest
    @DeleteMapping("{id}")
    public ResponseEntity<ResumeDTO> deleteById(@PathVariable("id") String id) {
        return resumeService.deleteById(id);
    }

    @LoggableRequest
    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody ResumeDTO resume) {
        return resumeService.update(resume);
    }
    
}
