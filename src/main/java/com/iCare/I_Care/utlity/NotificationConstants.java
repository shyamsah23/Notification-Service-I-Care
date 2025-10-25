package com.iCare.I_Care.utlity;

import com.iCare.I_Care.exception.NotificationException;

public class NotificationConstants {

    private NotificationConstants() throws NotificationException {
        throw new NotificationException("This is a constant class - Cant Create Object");
    }

    public static final String NOTIFICATION_ERROR = "Error While Sending Notification - Some Validations Missing";
    public static final String GLOBAL_ERROR = "Something Went Wrong";
    public static final String NOTIFICATION_DISABLED = "Notification is Disabled";
    public static final String MAIL_SENDED_SUCCESSFULLY= "Mail Sended Successfully";
}
