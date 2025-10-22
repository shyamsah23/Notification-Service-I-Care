package com.iCare.I_Care.enums;


public enum NotificationEnum {
    DOCTOR_REGISTER("templates/doctor-register.html"),
    PATIENT_REGISTER("templates/patient-register.html");

    private String path;

    NotificationEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
