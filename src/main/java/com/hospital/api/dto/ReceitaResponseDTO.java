package com.hospital.api.dto;
import com.hospital.api.model.Receita;

public class ReceitaResponseDTO {
    private Long id;
    private String descricao;
    private String medicamentos;
    private String data;
    private Long consultaId;
    private String pacienteNome;
    private String medicoNome;

    public ReceitaResponseDTO(Receita receita) {
        this.id = receita.getId();
        this.descricao = receita.getDescricao();
        this.medicamentos = receita.getMedicamentos();
        this.data = receita.getData();

        if (receita.getConsulta() != null) {
            this.consultaId = receita.getConsulta().getId();

            if (receita.getConsulta().getPaciente() != null) {
                this.pacienteNome = receita.getConsulta().getPaciente().getNome();
            }
            if (receita.getConsulta().getMedico() != null) {
                this.medicoNome = receita.getConsulta().getMedico().getNome();
            }
        }
    }

    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getMedicamentos() { return medicamentos; }
    public String getData() { return data; }
    public Long getConsultaId() { return consultaId; }
    public String getPacienteNome() { return pacienteNome; }
    public String getMedicoNome() { return medicoNome; }
}
