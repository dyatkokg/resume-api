package me.dyatkokg.demo.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.demo.entity.Resume;
import me.dyatkokg.demo.service.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PutMapping("create")
    public ResponseEntity<?> create(@RequestBody Resume resume){
        return resumeService.create(resume);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id ){
        return resumeService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id){
        return resumeService.deleteById(id);
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody Resume resume){
        return resumeService.update(resume);
    }

}
