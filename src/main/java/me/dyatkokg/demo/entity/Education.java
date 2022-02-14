package me.dyatkokg.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Education {

    private String place;
    private Integer startYear;
    private Integer endYear;
    private String specialization;

}
