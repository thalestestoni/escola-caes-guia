package hkeller.escolacaesguia.dtos;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.apache.catalina.connector.Response;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jakarta.validation.constraints.NotBlank;

public class CreateTutorDto {
    @Autowired
    private Environment env;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private Long cpf;

    @NotBlank
    private String password;

    @NotBlank
    private LocalDateTime dtNascimento;

    @NotBlank
    private String telCelular;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDtNascimento() {
        return this.dtNascimento;
    }

    public void setDtNascimento(LocalDateTime dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getTelCelular() {
        return this.telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", password='" + getPassword() + "'" +
            ", dtNascimento='" + getDtNascimento() + "'" +
            ", telCelular='" + getTelCelular() + "'" +
            "}";
    }



    
    
}
