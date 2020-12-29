package com.wolox.gallery.domain.exception;


import static com.wolox.gallery.infrastructure.config.GalleryMessage.msg;

public class DataNotFoundException extends GalleryException {

    public DataNotFoundException(GalleryNotificationCode notificationCode) {

        super(msg(notificationCode.getMessage()), notificationCode);

    }

}
