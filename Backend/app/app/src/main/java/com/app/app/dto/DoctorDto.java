package com.app.app.dto;

import com.app.app.entities.Specialities;

public class DoctorDto extends PatientDto{
    private Specialities speciality;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public int getExperience() {
        return experience;
    }

    public void setSpeciality(Specialities speciality) {
        this.speciality = speciality;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Specialities getSpeciality() {
        return speciality;
    }

    private int experience;
}
