package com.wolox.gallery.domain.exception;

import lombok.Getter;

public class GalleryException extends RuntimeException {

    @Getter
    private final GalleryNotificationCode notificationCode;

    public GalleryException(String message, GalleryNotificationCode notificationCode) {

        super(message);
        this.notificationCode = notificationCode;

    }

    public GalleryException(String message, GalleryNotificationCode notificationCode, Throwable cause) {

        super(message, cause);
        this.notificationCode = notificationCode;

    }
}