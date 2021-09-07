package com.SNI.SIS.Service;

import com.SNI.SIS.Dto.UniversityDto;

import java.util.List;

public interface IUniversityService {
    List<UniversityDto> getAllUniversities();
    UniversityDto getSpesificUniversity(Long id);
    UniversityDto updateUniversity(Long id, UniversityDto universityDto);
    UniversityDto createUniversity(UniversityDto universityDto);
    Boolean deleteUniversity(Long id);
}
