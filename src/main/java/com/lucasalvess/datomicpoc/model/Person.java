package com.lucasalvess.datomicpoc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Person implements Serializable {

    private Long id;
    private String name;
    private String mothersName;
    private String gender;
    private String email;
    private Date birthDate;
    private String materialStatus;
    private String occupation;
    private String profession;
    private Double patrimony;
    private String spouseName;
    private String countryBirth;
    private String stateBirth;
    private String cityBirth;
    private String ddd;
    private String phone;
    private String education;
}
