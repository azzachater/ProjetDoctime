package com.app.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;
    private String message;
    private String statut;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;

}

