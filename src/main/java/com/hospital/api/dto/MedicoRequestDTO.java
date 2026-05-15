package com.hospital.api.dto;
import jakarta.validation.constraints.NotBlank;

public class MedicoRequestDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    private String especialidade;
    private String email;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
