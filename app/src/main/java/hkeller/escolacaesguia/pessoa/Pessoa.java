package hkeller.escolacaesguia.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pessoa")
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false,name = "nome")
  private String nome;
  @Column(nullable = false,name = "data_nascimento")
  private Date dataNascimento;
  @Column(nullable = false,name = "cpf")
  private String cpf;
  @Column(name = "telefone_celular")
  private String telefoneCelular;
  @Column(name = "telefone_fixo")
  private String telefoneFixo;
  @Column(name = "created_at")
  private Timestamp created_at;
  @Column(name = "updated_at")
  private Timestamp updated_at;
}
