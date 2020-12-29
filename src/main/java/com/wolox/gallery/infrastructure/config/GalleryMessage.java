package com.wolox.gallery.infrastructure.config;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

public class GalleryMessage {

    public enum MsgName {

        INFO_API_NAME,
        DATA_NOT_FOUND,
        ALBUM_DATA_NOT_FOUND,
        ACCESS_DENIED;

    }

    private static MessageSourceAccessor accessor;

    static {
        accessor = initAccessor();
    }

    private static MessageSourceAccessor initAccessor() {

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return new MessageSourceAccessor(messageSource, Locale.forLanguageTag("es"));

    }

    public static String msg(GalleryMessage.MsgName name) {

        String asProperty = name.toString().toLowerCase().replace("_", ".");
        return accessor.getMessage(asProperty);

    }

    public static String msg(GalleryMessage.MsgName name, Object... params) {

        String asProperty = name.toString().toLowerCase().replace("_", ".");
        return accessor.getMessage(asProperty, params);

    }

    public static String apiName() {

        return msg(GalleryMessage.MsgName.INFO_API_NAME);

    }

}
