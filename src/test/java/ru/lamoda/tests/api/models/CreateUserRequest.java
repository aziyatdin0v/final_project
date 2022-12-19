package ru.lamoda.tests.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class CreateUserRequest {
    private String name, job;
}