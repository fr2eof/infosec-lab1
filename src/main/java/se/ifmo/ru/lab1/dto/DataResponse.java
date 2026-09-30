package se.ifmo.ru.lab1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DataResponse {
    private Long id;
    private String title;
    private String content;
}
