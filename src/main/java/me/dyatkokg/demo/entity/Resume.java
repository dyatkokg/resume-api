package me.dyatkokg.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Resume")
public class Resume {

    @Id
    private String id;

    private PersonalData data;

    private String position;

    private List<String> skills;

    private List<EmploymentExperience> experience;

    private List<Education> educations;

    private String aboutMe;

    private Contacts contacts;

}
