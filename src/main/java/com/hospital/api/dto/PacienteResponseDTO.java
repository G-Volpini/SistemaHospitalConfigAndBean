package com.hospital.api.dto;
import com.hospital.api.model.Paciente;

public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String dataNascimento;

    public PacienteResponseDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
        this.email = paciente.getEmail();
        this.telefone = paciente.getTelefone();
        this.dataNascimento = paciente.getDataNascimento();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getDataNascimento() { return dataNascimento; }
}
