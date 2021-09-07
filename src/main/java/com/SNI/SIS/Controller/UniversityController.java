package com.SNI.SIS.Controller;

import com.SNI.SIS.Dto.UniversityDto;
import com.SNI.SIS.Service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    private final IUniversityService universityService;


    @Autowired
    public UniversityController(IUniversityService universityService) {
        this.universityService = universityService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UniversityDto> getSpesificUniversity(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(universityService.getSpesificUniversity(id));
    }


    @GetMapping
    public ResponseEntity<List<UniversityDto>> getAllUniversities(){
        return ResponseEntity.ok(universityService.getAllUniversities());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityDto> updateUniversity(
            @PathVariable("id") Long id,
            @Valid @RequestBody UniversityDto universityDto
    ){
        return ResponseEntity.ok(universityService.updateUniversity(id,universityDto));
    }

    @PostMapping
    public ResponseEntity<UniversityDto> createUniversity(
            @Valid @RequestBody UniversityDto universityDto
    ){
        return ResponseEntity.ok(universityService.createUniversity(universityDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUniversity(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(universityService.deleteUniversity(id));
    }




}
