package com.hospital.api.dto;
import com.hospital.api.model.Consulta;

public class ConsultaResponseDTO {
    private Long id;
    private String data;
    private String observacoes;
    private Long pacienteId;
    private String pacienteNome;
    private Long medicoId;
    private String medicoNome;
    private Long convenioId;
    private String convenioNome;

    public ConsultaResponseDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.data = consulta.getData();
        this.observacoes = consulta.getObservacoes();

        if (consulta.getPaciente() != null) {
            this.pacienteId = consulta.getPaciente().getId();
            this.pacienteNome = consulta.getPaciente().getNome();
        }
        if (consulta.getMedico() != null) {
            this.medicoId = consulta.getMedico().getId();
            this.medicoNome = consulta.getMedico().getNome();
        }
        if (consulta.getConvenio() != null) {
            this.convenioId = consulta.getConvenio().getId();
            this.convenioNome = consulta.getConvenio().getNome();
        }
    }

    public Long getId() { return id; }
    public String getData() { return data; }
    public String getObservacoes() { return observacoes; }
    public Long getPacienteId() { return pacienteId; }
    public String getPacienteNome() { return pacienteNome; }
    public Long getMedicoId() { return medicoId; }
    public String getMedicoNome() { return medicoNome; }
    public Long getConvenioId() { return convenioId; }
    public String getConvenioNome() { return convenioNome; }
}
