package hkeller.escolacaesguia.evento.model;

import hkeller.escolacaesguia.cao.model.Cao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "evento")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @Column
    private boolean notificarTutor;

    @ManyToOne
    @JoinColumn(name = "id_cao")
    private Cao cao;

}
