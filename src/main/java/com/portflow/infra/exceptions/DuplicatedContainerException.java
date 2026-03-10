package com.portflow.infra.exceptions;

public class DuplicatedContainerException extends RuntimeException {

    public DuplicatedContainerException(String message) {
        super(message);
    }

}
