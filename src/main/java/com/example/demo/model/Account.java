package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    private String id;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy mm:ss")
    private LocalDateTime creationDate;
    private Double amount;
    private Currency currency;
}
