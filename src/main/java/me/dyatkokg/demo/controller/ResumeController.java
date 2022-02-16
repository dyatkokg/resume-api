package me.dyatkokg.demo.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.demo.dto.ResumeDTO;
import me.dyatkokg.demo.entity.Resume;
import me.dyatkokg.demo.service.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PutMapping("create")
    public ResponseEntity<ResumeDTO> create(@RequestBody ResumeDTO resume){
        return resumeService.create(resume);
    }


    @GetMapping("find-all")
    public ResponseEntity<List<ResumeDTO>> findAll() {
        return resumeService.findAll();
    }


    @GetMapping("{id}")
    public ResponseEntity<ResumeDTO> getById(@PathVariable("id") String id ){
        return resumeService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResumeDTO> deleteById(@PathVariable("id") String id){
        return resumeService.deleteById(id);
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody ResumeDTO resume){
        return resumeService.update(resume);
    }


    //создать обьект
    //проверить контролеры
    //собственные исключения создац
    //постраничность!
    //логирование
    //
}
