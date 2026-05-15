package com.hospital.api.dto;
import jakarta.validation.constraints.NotNull;

public class ReceitaRequestDTO {
    private String descricao;
    private String medicamentos;
    private String data;

    @NotNull
    private Long consultaId;

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getMedicamentos() { return medicamentos; }
    public void setMedicamentos(String medicamentos) { this.medicamentos = medicamentos; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public Long getConsultaId() { return consultaId; }
    public void setConsultaId(Long consultaId) { this.consultaId = consultaId; }
}
