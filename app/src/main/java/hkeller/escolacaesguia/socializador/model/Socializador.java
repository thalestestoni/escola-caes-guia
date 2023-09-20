package hkeller.escolacaesguia.socializador.model;

import hkeller.escolacaesguia.pessoa.Pessoa;
import hkeller.escolacaesguia.socializador.enums.EnumEstadoCivil;
import hkeller.escolacaesguia.socializador.enums.EnumGrauInstrucao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "socializador")
public class Socializador implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String rg;

  @Column(name = "orgao_emissor", nullable = false)
  private String orgaoEmissor;

  private String endereco;
  @Enumerated(EnumType.STRING)
  @Column(name = "grau_instrucao")
  private EnumGrauInstrucao grauInstrucao;

  private String profissao;
  @Column(name = "local_trabalho")
  private String localTrabalho;
  private boolean estuda;

  @Column(name = "local_estudo")
  private String localEstudo;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado_civil")
  private EnumEstadoCivil estadoCivil;

  @OneToOne(optional = false, orphanRemoval = true)
  @JoinColumn(name = "id_pessoa", nullable = false)
  private Pessoa pessoa;

}
