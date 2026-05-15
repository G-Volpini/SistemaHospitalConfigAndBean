package com.hospital.api.service;

import com.hospital.api.dto.ConsultaRequestDTO;
import com.hospital.api.dto.ConsultaResponseDTO;
import com.hospital.api.exception.RegraNegocioException;
import com.hospital.api.model.Consulta;
import com.hospital.api.model.Convenio;
import com.hospital.api.model.Medico;
import com.hospital.api.model.Paciente;
import com.hospital.api.repository.ConsultaRepository;
import com.hospital.api.repository.ConvenioRepository;
import com.hospital.api.repository.MedicoRepository;
import com.hospital.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConvenioRepository convenioRepository;

    public List<ConsultaResponseDTO> listarTodos() {
        return consultaRepository.findAll()
                .stream()
                .map(ConsultaResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ConsultaResponseDTO buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada: id=" + id));
        return new ConsultaResponseDTO(consulta);
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO dto) {
        Consulta consulta = new Consulta();
        preencherDados(consulta, dto);
        return new ConsultaResponseDTO(consultaRepository.save(consulta));
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada: id=" + id));
        preencherDados(consulta, dto);
        return new ConsultaResponseDTO(consultaRepository.save(consulta));
    }

    public void excluir(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new RegraNegocioException("Consulta não encontrada: id=" + id);
        }
        consultaRepository.deleteById(id);
    }

    private void preencherDados(Consulta consulta, ConsultaRequestDTO dto) {
        consulta.setData(dto.getData());
        consulta.setObservacoes(dto.getObservacoes());

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RegraNegocioException("Paciente não encontrado: id=" + dto.getPacienteId()));
        consulta.setPaciente(paciente);

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RegraNegocioException("Médico não encontrado: id=" + dto.getMedicoId()));
        consulta.setMedico(medico);

        if (dto.getConvenioId() != null) {
            Convenio convenio = convenioRepository.findById(dto.getConvenioId())
                    .orElseThrow(() -> new RegraNegocioException("Convênio não encontrado: id=" + dto.getConvenioId()));
            consulta.setConvenio(convenio);
        } else {
            consulta.setConvenio(null);
        }
    }
}
