package com.wolox.gallery.infrastructure.controller.filter;

import com.wolox.gallery.infrastructure.config.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Order(HIGHEST_PRECEDENCE)
@Component
@Slf4j
public class ApiLoggingFilter extends AbstractRequestLoggingFilter {

    private SecurityProperties securityProperties;
    public ApiLoggingFilter(SecurityProperties securityProperties) {
        super();
        super.setIncludeQueryString(true);
        super.setIncludePayload(true);
        super.setMaxPayloadLength(10000);
        super.setIncludeHeaders(true);
        super.setBeforeMessagePrefix("---------- Incoming Request ----------\n\t");
        this.securityProperties = securityProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                                    FilterChain chain) throws ServletException, IOException {
        super.doFilterInternal(req, res, chain);
        log.debug("---------- Returning Response - {} - {} ----------", res.getStatus(),
                req.getRequestURI());
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.debug(
                message
                        .replace(";headers=", "\n\theaders:\n\t\t")
                        .replace(";payload=", "\n\tpayload:\n\t\t")
                        + "\n\tmethod: \n\t\t{}"
                        + "\n\tcookies: \n\t\t{}"
                        + "\n\tauth: {}"
                , request.getMethod()
                , listCookies(request.getCookies())
                , buildAuthInfo());
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
    }

    private String buildAuthInfo() {
        if (!securityProperties.isEnable()) {
            return "Security Disabled";
        } else {
            return "Security Enabled";
        }
    }


    private String listCookies(Cookie[] cookies) {
        if (cookies == null) {
            return "[]";
        }
        return Arrays.stream(cookies).map(cookie -> cookie.getName() + ":" + cookie.getValue())
                .collect(Collectors.joining(";"));
    }

}
