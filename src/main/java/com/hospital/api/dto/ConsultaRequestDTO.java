package com.hospital.api.dto;
import jakarta.validation.constraints.NotNull;

public class ConsultaRequestDTO {
    private String data;
    private String observacoes;

    @NotNull
    private Long pacienteId;

    @NotNull
    private Long medicoId;

    private Long convenioId;

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }

    public Long getMedicoId() { return medicoId; }
    public void setMedicoId(Long medicoId) { this.medicoId = medicoId; }

    public Long getConvenioId() { return convenioId; }
    public void setConvenioId(Long convenioId) { this.convenioId = convenioId; }
}
