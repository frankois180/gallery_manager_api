package com.wolox.gallery.domain.exception;


import com.wolox.gallery.infrastructure.config.GalleryMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum GalleryNotificationCode {

    DATA_NOT_FOUND(GalleryMessage.MsgName.DATA_NOT_FOUND, "IN_ERR_NF"),
    ALBUM_DATA_NOT_FOUND(GalleryMessage.MsgName.ALBUM_DATA_NOT_FOUND, "IN_ALB_NF"),
    ACCESS_DENIED(GalleryMessage.MsgName.ACCESS_DENIED, "IN_ACC_DND");

    private GalleryMessage.MsgName message;
    private String apiCode;

}
