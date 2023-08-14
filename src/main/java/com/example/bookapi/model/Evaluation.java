package com.example.bookapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="evaluation")
public class Evaluation {


    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private LocalDateTime creationDate = LocalDateTime.now();

    private String massage;

    @Max(value = 5)
    @Min(value=1)
    private int rating;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private boolean isBookEvaluation = true ;

    @ManyToOne(optional = true)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(optional = true)
    @JoinColumn(name = "writer_id")
    private Writer writer;



}

