package com.hospital.api.dto;
import com.hospital.api.model.Medico;

public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String crm;
    private String especialidade;
    private String email;

    public MedicoResponseDTO(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.especialidade = medico.getEspecialidade();
        this.email = medico.getEmail();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCrm() { return crm; }
    public String getEspecialidade() { return especialidade; }
    public String getEmail() { return email; }
}
