package com.example.curriculo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "idiomas")
public class Idiomas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
