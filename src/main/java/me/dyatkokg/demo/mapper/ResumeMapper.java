package me.dyatkokg.demo.mapper;

import me.dyatkokg.demo.dto.ResumeDTO;
import me.dyatkokg.demo.entity.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "data",target = "data")
    @Mapping(source = "position",target = "position")
    @Mapping(source = "skills",target = "skills")
    @Mapping(source = "experience",target = "experience")
    @Mapping(source = "educations",target = "educations")
    @Mapping(source = "aboutMe",target = "aboutMe")
    @Mapping(source = "contacts",target = "contacts")
    ResumeDTO toDTO(Resume resume);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "data",target = "data")
    @Mapping(source = "position",target = "position")
    @Mapping(source = "skills",target = "skills")
    @Mapping(source = "experience",target = "experience")
    @Mapping(source = "educations",target = "educations")
    @Mapping(source = "aboutMe",target = "aboutMe")
    @Mapping(source = "contacts",target = "contacts")
    Resume toEntity(ResumeDTO dto);
}
