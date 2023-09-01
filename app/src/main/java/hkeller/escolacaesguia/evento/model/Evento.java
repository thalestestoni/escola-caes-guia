package hkeller.escolacaesguia.evento.model;

import java.io.Serializable;
import java.util.Date;

import hkeller.escolacaesguia.cao.model.Cao;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
