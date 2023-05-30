package com.desafio.api.exception_handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    INVALID_DATA("/invalid-data", "Invalid data"),
    SYSTEM_ERROR("/system-error", "System error"),
    USER_AUTHENTICATION_FAILED("/user-authentication-failed", "User authentication failed"),
    RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found"),
    RESOURCE_IN_USE("/resource-in-use", "Resource in use"),
    BUSINESS_ERROR("/business-error", "Business rule violation");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://desafio-rgc.com" + path;
        this.title = title;
    }

}
