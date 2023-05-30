package com.desafio.domain.exception;

public class ResourceNotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long id, String resourceName) {
        super(resourceName + " not found with ID " + id);
    }

}
