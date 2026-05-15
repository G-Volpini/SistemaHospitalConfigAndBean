package com.hospital.api.dto;

import java.util.List;

public class PacienteCompletoResponseDTO {

    private PacienteResponseDTO paciente;
    private MedicoResponseDTO medicoResponsavel;
    private ConvenioResponseDTO convenio;
    private List<ConsultaResponseDTO> consultas;
    private ProntuarioResponseDTO prontuario;
    private ReceitaResponseDTO receita;

    public PacienteCompletoResponseDTO(
            PacienteResponseDTO paciente,
            MedicoResponseDTO medicoResponsavel,
            ConvenioResponseDTO convenio,
            List<ConsultaResponseDTO> consultas,
            ProntuarioResponseDTO prontuario,
            ReceitaResponseDTO receita) {

        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
        this.convenio = convenio;
        this.consultas = consultas;
        this.prontuario = prontuario;
        this.receita = receita;
    }

    public PacienteResponseDTO getPaciente() { return paciente; }
    public MedicoResponseDTO getMedicoResponsavel() { return medicoResponsavel; }
    public ConvenioResponseDTO getConvenio() { return convenio; }
    public List<ConsultaResponseDTO> getConsultas() { return consultas; }
    public ProntuarioResponseDTO getProntuario() { return prontuario; }
    public ReceitaResponseDTO getReceita() { return receita; }
}
