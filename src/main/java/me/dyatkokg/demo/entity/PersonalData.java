package me.dyatkokg.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalData {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private String location;

}
