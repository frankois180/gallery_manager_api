package com.wolox.gallery.infrastructure.advice;

import com.wolox.gallery.domain.exception.DataNotFoundException;
import com.wolox.gallery.domain.exception.GalleryException;
import com.wolox.gallery.domain.exception.UnexpectedException;
import com.wolox.gallery.infrastructure.controller.dto.ApiResponseDto;
import com.wolox.gallery.infrastructure.controller.dto.NotificationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
@ControllerAdvice
public class GeneralAdviceController {

    private static final List<ErrorDescriptor> ERROR_CATALOG = new ArrayList<>();

    static {

        ERROR_CATALOG.add(new ErrorDescriptor(DataNotFoundException.class,
                HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString()));
        ERROR_CATALOG.add(new ErrorDescriptor(UnexpectedException.class,
                HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString()));

    }

    @ExceptionHandler({
            DataNotFoundException.class,
            UnexpectedException.class
    })
    public final ResponseEntity<ApiResponseDto> handleAllHandledExceptions(
            GalleryException exception) {

        log.error(exception.getMessage(), exception);

        return ResponseEntity.status(findDescriptorByException(exception).httpStatus)
                .body(ApiResponseDto.builder().data(null)
                        .notification(buildNotification(exception.getMessage(),
                                exception.getNotificationCode().getApiCode()))
                        .build());

    }

    @ExceptionHandler({
            Exception.class
    })
    public final ResponseEntity<ApiResponseDto> handleAllExceptions(Exception exception) {

        log.error(exception.getMessage(), exception);

        ErrorDescriptor errorDesc = findDescriptorByException(exception);

        return ResponseEntity.status(errorDesc.getHttpStatus())
                .body(ApiResponseDto.builder().data(null)
                        .notification(buildNotification(exception.getMessage(),
                                errorDesc.getResponseCode()))
                        .build());

    }

    private NotificationDto buildNotification(String message, String apicode) {

        return NotificationDto.builder()
                .description(message)
                .apiCode(apicode)
                .build();

    }

    private ErrorDescriptor findDescriptorByException(Exception ex) {

        return ERROR_CATALOG.stream()
                .filter(errorDes -> errorDes.getExType().equals(ex.getClass()))
                .findFirst()
                .orElse(new ErrorDescriptor(
                        null, HttpStatus.INTERNAL_SERVER_ERROR,
                        HttpStatus.INTERNAL_SERVER_ERROR.toString()));

    }

    @Getter
    private static class ErrorDescriptor {

        Class<? extends Throwable> exType;
        HttpStatus httpStatus;
        String responseCode;

        private ErrorDescriptor(Class<? extends Throwable> exType,
                                HttpStatus httpStatus, String responseCode) {

            this.exType = exType;
            this.httpStatus = httpStatus;
            this.responseCode = responseCode;

        }

    }

}
