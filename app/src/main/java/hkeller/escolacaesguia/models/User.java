package hkeller.escolacaesguia.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, name = "data_nascimento")
    private Date dataNascimento;

    @Column(nullable = false, name = "telefone_celular")
    private String telefoneCelular;

    @Column(name = "telefone_fixo")
    private String telefoneFixo;

    @Column(nullable = false)
    private boolean ativo;
}
