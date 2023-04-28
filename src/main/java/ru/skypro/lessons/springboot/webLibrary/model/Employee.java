package ru.skypro.lessons.springboot.webLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private final String name;
    private final double salary;
}
