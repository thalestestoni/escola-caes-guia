package hkeller.escolacaesguia.visita.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
public class RequisicaoCadastroVisitasDto {
    @NotEmpty(message = "Por favor, preencha o campo Nome da Escola.")
    private String nomeEscola;

    @NotEmpty(message = "Por favor, preencha o campo E-mail.")
    @Email(message = "Por favor, forneça um endereço de e-mail válido.")
    private String email;

    @NotEmpty(message = "Por favor, preencha o campo Endereço.")
    private String endereco;

    @NotEmpty(message = "Por favor, preencha o campo Bairro.")
    private String bairro;

    @NotEmpty(message = "Por favor, preencha o campo Cidade.")
    private String cidade;

    @NotEmpty(message = "Por favor, preencha o campo CEP.")
    private String cep;

    @NotEmpty(message = "Por favor, preencha o campo Telefone da Escola.")
    private String telefoneEscola;

    @NotEmpty(message = "Por favor, preencha o campo Nome do(a) professor(a) responsável pela visita.")
    private String nomeResponsavel;

    @NotEmpty(message = "Por favor, preencha o campo Telefone (whats) do(a) professor(a).")
    private String telefoneResponsavel;

    @NotNull(message = "Por favor, preencha o campo Número aproximado de alunos.")
    private Integer numeroAlunos;

    @NotEmpty(message = "Por favor, preencha o campo Classe escolar/série.")
    private String serieEscolar;

    @NotEmpty(message = "Por favor, preencha o campo Idade média dos alunos.")
    private String idadeAlunos;

    @NotEmpty(message = "Por favor, preencha o campo Objetivo da escola ao receber a visita da Escola HKeller.")
    private String textoObjetivo;

    @NotNull(message = "Por favor, escolha uma opção para a pergunta.")
    private Boolean simNao;

    @NotNull(message = "Por favor, preencha o campo Data sugerida para a visita.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVisita;

    @NotEmpty(message = "Por favor, preencha o campo Horário sugerido para a visita.")
    private String horaVisita;

    // Getters e setters
  }

