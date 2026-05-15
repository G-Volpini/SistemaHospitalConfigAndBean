package com.hospital.api.dto;
import com.hospital.api.model.Prontuario;

public class ProntuarioResponseDTO {
    private Long id;
    private String historico;
    private String dataAbertura;
    private Long pacienteId;
    private String pacienteNome;

    public ProntuarioResponseDTO(Prontuario prontuario) {
        this.id = prontuario.getId();
        this.historico = prontuario.getHistorico();
        this.dataAbertura = prontuario.getDataAbertura();

        if (prontuario.getPaciente() != null) {
            this.pacienteId = prontuario.getPaciente().getId();
            this.pacienteNome = prontuario.getPaciente().getNome();
        }
    }

    public Long getId() { return id; }
    public String getHistorico() { return historico; }
    public String getDataAbertura() { return dataAbertura; }
    public Long getPacienteId() { return pacienteId; }
    public String getPacienteNome() { return pacienteNome; }
}
