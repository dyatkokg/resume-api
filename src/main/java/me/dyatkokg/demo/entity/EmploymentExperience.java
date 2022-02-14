package me.dyatkokg.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmploymentExperience {

    private String company;
    private String position;
    private Integer startYear;
    private Integer endYear;
    private List<String> responsibilities;
}
