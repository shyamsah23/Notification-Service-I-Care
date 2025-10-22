package com.iCare.I_Care.utlity;

import com.iCare.I_Care.exception.NotificationException;

public class NotificationConstants {

    private NotificationConstants() throws NotificationException {
        throw new NotificationException("This is a constant class - Cant Create Object");
    }

    private static final String NOTIFICATION_ERROR = "Error While Sending Notification - Some Validations Missing";
    private static final String GLOBAL_ERROR = "Something Went Wrong";
}
