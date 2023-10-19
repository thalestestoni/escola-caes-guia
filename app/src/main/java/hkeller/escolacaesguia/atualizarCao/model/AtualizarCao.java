package hkeller.escolacaesguia.atualizarCao.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atualizacoes_cao")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AtualizarCao implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String endereco;

  @Column(nullable = false)
  private String telefone;

  @Column(name = "nome_contato_recado", nullable = false)
  private String nomeContatoRecado;

  @Column(name = "telefone_contato_recado", nullable = false)
  private String telefoneContatoRecado;

  @Column(name = "nome_cao", nullable = false)
  private String nomeCao;

  @Column(name = "situacao_cao", nullable = false)
  private String situacaoCao;

  @Column(name = "antiparasitario_interno_data", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiparasitarioInternoData;

  @Column(name = "antiparasitario_externo_data", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiparasitarioExternoData;

  @Column(name = "troca_coleira_scalibor_data", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date trocaColeiraScaliborData;

  @Column(name = "tem_caderneta_vacinacao", nullable = false)
  private String temCadernetaVacinacao;

  @Column(name = "ultima_vacina_nobivac_dhppi_l", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date ultimaVacinaNobivacDhppiL;

  @Column(name = "ultima_vacina_nobivac_raiva", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date ultimaVacinaNobivacRaiva;

  @Column(name = "tem_bloco_veterinario", nullable = false)
  private String temBlocoVeterinario;

  @Column(name = "tem_carteirinha_socializador", nullable = false)
  private String temCarteirinhaSocializador;

  @Column(name = "created_at", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createdAt;
}

