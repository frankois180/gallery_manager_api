package com.wolox.gallery.domain.exception;

import com.wolox.gallery.infrastructure.config.GalleryMessage;

public class UnexpectedException extends GalleryException {

    public UnexpectedException(GalleryNotificationCode notificationCode) {

        super(GalleryMessage.msg(notificationCode.getMessage()), notificationCode);

    }
}
