package com.portflow.infra.response.error;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record StandardError(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String message,
        String path,
        Map<String, String> errors
) {
}
