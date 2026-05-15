package com.hospital.api.dto;
import jakarta.validation.constraints.NotNull;

public class ProntuarioRequestDTO {
    private String historico;
    private String dataAbertura;

    @NotNull
    private Long pacienteId;

    public String getHistorico() { return historico; }
    public void setHistorico(String historico) { this.historico = historico; }

    public String getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(String dataAbertura) { this.dataAbertura = dataAbertura; }

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
}
