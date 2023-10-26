package com.msbeigi.librarybackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ResponseMapping {
    private HttpStatus status;
    private LocalDateTime dateTime;
    private List<?> results;

}
