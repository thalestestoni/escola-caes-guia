package hkeller.escolacaesguia.socializador.model;

import hkeller.escolacaesguia.common.abstracts.AbstractPessoa;
import hkeller.escolacaesguia.socializador.enums.EnumEstadoCivil;
import hkeller.escolacaesguia.socializador.enums.EnumGrauInstrucao;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "form_cadastro_inicial_socializador")
public class Socializador implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "id_pessoa")
  private Long idPessoa;

  private String email;
  private String rg;
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
}
