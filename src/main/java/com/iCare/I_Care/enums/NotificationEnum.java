package com.iCare.I_Care.enums;


public enum NotificationEnum {
    DOCTOR_REGISTER("templates/doctor-register.html"),
    PATIENT_REGISTER("templates/patient-register.html"),
    ADMIN_REGISTER("templates/admin-register.html"),
    APPOINTMENT_BOOKED("templates/appointment-booked.html"),
    APPOINTMENT_CANCELLED("templates/appointment-cancelled.html"),
    APPOINTMENT_COMPLETED("templates/appointment-completed.html"),
    APPOINTMENT_RESCHEDULED("templates/appointment-reschedule.html");

    private String path;

    NotificationEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
