package com.app.app.dto;

import com.app.app.entities.Specialities;

public class DoctorDto extends PatientDto{
    private Specialities speciality;
    private String address;
    private int experience;
}
