package Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String instituicao;
    private String inicio;
    private String fim;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}