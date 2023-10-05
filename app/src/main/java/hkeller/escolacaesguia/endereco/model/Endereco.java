package hkeller.escolacaesguia.endereco.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {
  @Id
  private int cep;

  @Column(nullable = false)
  private String logradouro;

  private String numero;

  @Column(nullable = false)
  private String bairro;

  @ManyToOne
  @JoinColumn(name = "id_cidade")
  private Cidade cidade;

  @ManyToOne
  @JoinColumn(name = "id_estado")
  private Estado estado;
}
