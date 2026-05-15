package com.hospital.api.service;

import com.hospital.api.dto.PacienteRequestDTO;
import com.hospital.api.dto.PacienteResponseDTO;
import com.hospital.api.exception.RegraNegocioException;
import com.hospital.api.model.Paciente;
import com.hospital.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteResponseDTO> listarTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteResponseDTO::new)
                .collect(Collectors.toList());
    }

    public PacienteResponseDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Paciente não encontrado: id=" + id));
        return new PacienteResponseDTO(paciente);
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        preencherDados(paciente, dto);
        return new PacienteResponseDTO(pacienteRepository.save(paciente));
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Paciente não encontrado: id=" + id));
        preencherDados(paciente, dto);
        return new PacienteResponseDTO(pacienteRepository.save(paciente));
    }

    public void excluir(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RegraNegocioException("Paciente não encontrado: id=" + id);
        }
        pacienteRepository.deleteById(id);
    }

    private void preencherDados(Paciente paciente, PacienteRequestDTO dto) {
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefone(dto.getTelefone());
        paciente.setDataNascimento(dto.getDataNascimento());
    }
}
