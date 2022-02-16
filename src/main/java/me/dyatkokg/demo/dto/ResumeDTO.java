package me.dyatkokg.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dyatkokg.demo.entity.Contacts;
import me.dyatkokg.demo.entity.Education;
import me.dyatkokg.demo.entity.EmploymentExperience;
import me.dyatkokg.demo.entity.PersonalData;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDTO {

    private String id;

    private PersonalData data;

    private String position;

    private List<String> skills;

    private List<EmploymentExperience> experience;

    private List<Education> educations;

    private String aboutMe;

    private Contacts contacts;
}
