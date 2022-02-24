package me.dyatkokg.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.dyatkokg.demo.aspect.LoggableRequest;
import me.dyatkokg.demo.dto.ResumeDTO;
import me.dyatkokg.demo.service.ResumeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Api(tags = "ResumeAPI")
@RestController
@RequestMapping("resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @ApiOperation(value = "Creating a new resume")
    @LoggableRequest
    @PutMapping("create")
    public ResponseEntity<ResumeDTO> create(@RequestBody ResumeDTO resume) {
        return resumeService.create(resume);
    }

    @ApiOperation(value = "Get page of all resumes")
    @LoggableRequest
    @GetMapping("find-all")
    public Page<ResumeDTO> findAll(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                   @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return resumeService.findAll(page, size);
    }

    @ApiOperation(value = "Get resume by id")
    @LoggableRequest
    @GetMapping("{id}")
    public ResponseEntity<ResumeDTO> getById(@PathVariable("id") String id) {
        return resumeService.getById(id);
    }

    @ApiOperation(value = "Remove resume by provided id")
    @LoggableRequest
    @DeleteMapping("{id}")
    public ResponseEntity<ResumeDTO> deleteById(@PathVariable("id") String id) {
        return resumeService.deleteById(id);
    }

    @ApiOperation(value = "Update resume by provided id")
    @LoggableRequest
    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody ResumeDTO resume) {
        return resumeService.update(resume);
    }
    
}
