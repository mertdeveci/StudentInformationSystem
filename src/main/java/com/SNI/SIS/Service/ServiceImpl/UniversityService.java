package com.SNI.SIS.Service.ServiceImpl;

import com.SNI.SIS.Dto.UniversityDto;
import com.SNI.SIS.Entity.Address;
import com.SNI.SIS.Entity.University;
import com.SNI.SIS.Repository.IUniversityRepository;
import com.SNI.SIS.Service.IUniversityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UniversityService implements IUniversityService {
    private final IUniversityRepository universityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UniversityService(IUniversityRepository universityRepository, ModelMapper modelMapper) {
        this.universityRepository = universityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UniversityDto getSpesificUniversity(Long id){
        UniversityDto universityDto = modelMapper.map(universityRepository.getById(id),UniversityDto.class);
        if(universityDto!=null){
            return universityDto;
        }else{
            universityDto.setName("University not found");
            universityDto.setAddress(null);
        }
        return universityDto;
    }


    @Override
    public List<UniversityDto> getAllUniversities() {
          return Arrays.asList(modelMapper.map(universityRepository.findAll(), UniversityDto[].class));
    }

    @Override
    public UniversityDto updateUniversity(Long id, UniversityDto universityDto) {
        if(!universityRepository.existsById(id)){
            throw new NoSuchElementException("Universite bulunamadı");
        }

        University university = universityRepository.getById(id);

        university.setName(universityDto.getName());
        university.setAddress(modelMapper.map(universityDto.getAddress(), Address.class));
        universityRepository.save(university);

        return getSpesificUniversity(id);
    }

    @Override
    public UniversityDto createUniversity(UniversityDto universityDto) {
        University university = modelMapper.map(universityDto, University.class);
        universityRepository.save(university);
        return universityDto;
    }

    @Override
    public Boolean deleteUniversity(Long id) {
        University university = universityRepository.getById(id);
        if(university!=null){
            universityRepository.delete(university);
            return true;
        }
        return false;
    }


}
