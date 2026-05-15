package com.hospital.api.service;

import com.hospital.api.dto.MedicoRequestDTO;
import com.hospital.api.dto.MedicoResponseDTO;
import com.hospital.api.exception.RegraNegocioException;
import com.hospital.api.model.Medico;
import com.hospital.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoResponseDTO> listarTodos() {
        return medicoRepository.findAll()
                .stream()
                .map(MedicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public MedicoResponseDTO buscarPorId(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Médico não encontrado: id=" + id));
        return new MedicoResponseDTO(medico);
    }

    public MedicoResponseDTO salvar(MedicoRequestDTO dto) {
        Medico medico = new Medico();
        preencherDados(medico, dto);
        return new MedicoResponseDTO(medicoRepository.save(medico));
    }

    public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Médico não encontrado: id=" + id));
        preencherDados(medico, dto);
        return new MedicoResponseDTO(medicoRepository.save(medico));
    }

    public void excluir(Long id) {
        if (!medicoRepository.existsById(id)) {
            throw new RegraNegocioException("Médico não encontrado: id=" + id);
        }
        medicoRepository.deleteById(id);
    }

    private void preencherDados(Medico medico, MedicoRequestDTO dto) {
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setEmail(dto.getEmail());
    }
}
