package com.hospital.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.api.dto.ConsultaResponseDTO;
import com.hospital.api.dto.ConvenioResponseDTO;
import com.hospital.api.dto.MedicoResponseDTO;
import com.hospital.api.dto.PacienteCompletoResponseDTO;
import com.hospital.api.dto.PacienteResponseDTO;
import com.hospital.api.dto.ProntuarioResponseDTO;
import com.hospital.api.dto.ReceitaResponseDTO;
import com.hospital.api.model.Consulta;
import com.hospital.api.model.Convenio;
import com.hospital.api.model.Medico;
import com.hospital.api.model.Paciente;
import com.hospital.api.model.Prontuario;
import com.hospital.api.model.Receita;

@RestController
@RequestMapping("/bean")
@CrossOrigin(origins = "*")
public class BeanController {
    @Autowired
    private Paciente pacientePadrao;

    @Autowired
    private Medico medicoCardiologista;

    @Autowired
    @Qualifier("medicoClinicoGeral")
    private Medico medicoClinicoGeral;

    @Autowired
    private Convenio convenioPadrao;

    @Autowired
    @Qualifier("consultaCardiologia")
    private Consulta consultaCardiologia;

    @Autowired
    @Qualifier("consultaClinicaGeral")
    private Consulta consultaClinicaGeral;

    @Autowired
    private Prontuario prontuarioPadrao;
    @Autowired
    private Receita receitaPadrao;

    @GetMapping
    public PacienteCompletoResponseDTO getPacienteCompleto() {
        return new PacienteCompletoResponseDTO(
                new PacienteResponseDTO(pacientePadrao),
                new MedicoResponseDTO(medicoCardiologista),
                new ConvenioResponseDTO(convenioPadrao),
                List.of(
                    new ConsultaResponseDTO(consultaCardiologia),
                    new ConsultaResponseDTO(consultaClinicaGeral)
                ),
                new ProntuarioResponseDTO(prontuarioPadrao),
                new ReceitaResponseDTO(receitaPadrao)
        );
    }
}
