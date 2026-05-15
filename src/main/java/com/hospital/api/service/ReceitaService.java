package com.hospital.api.service;

import com.hospital.api.dto.ReceitaRequestDTO;
import com.hospital.api.dto.ReceitaResponseDTO;
import com.hospital.api.exception.RegraNegocioException;
import com.hospital.api.model.Consulta;
import com.hospital.api.model.Receita;
import com.hospital.api.repository.ConsultaRepository;
import com.hospital.api.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<ReceitaResponseDTO> listarTodos() {
        return receitaRepository.findAll()
                .stream()
                .map(ReceitaResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ReceitaResponseDTO buscarPorId(Long id) {
        Receita receita = receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada: id=" + id));
        return new ReceitaResponseDTO(receita);
    }

    public ReceitaResponseDTO salvar(ReceitaRequestDTO dto) {
        Receita receita = new Receita();
        preencherDados(receita, dto);
        return new ReceitaResponseDTO(receitaRepository.save(receita));
    }

    public ReceitaResponseDTO atualizar(Long id, ReceitaRequestDTO dto) {
        Receita receita = receitaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada: id=" + id));
        preencherDados(receita, dto);
        return new ReceitaResponseDTO(receitaRepository.save(receita));
    }

    public void excluir(Long id) {
        if (!receitaRepository.existsById(id)) {
            throw new RegraNegocioException("Receita não encontrada: id=" + id);
        }
        receitaRepository.deleteById(id);
    }

    private void preencherDados(Receita receita, ReceitaRequestDTO dto) {
        receita.setDescricao(dto.getDescricao());
        receita.setMedicamentos(dto.getMedicamentos());
        receita.setData(dto.getData());

        Consulta consulta = consultaRepository.findById(dto.getConsultaId())
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada: id=" + dto.getConsultaId()));
        receita.setConsulta(consulta);
    }
}
