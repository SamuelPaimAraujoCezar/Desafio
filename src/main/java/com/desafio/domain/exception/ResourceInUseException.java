package com.desafio.domain.exception;

public class ResourceInUseException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public ResourceInUseException(Long id, String resourceName) {
        super(resourceName + " with ID " + id + " is being used");
    }

}
