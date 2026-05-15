package com.hospital.api.service;

import com.hospital.api.dto.ConvenioRequestDTO;
import com.hospital.api.dto.ConvenioResponseDTO;
import com.hospital.api.exception.RegraNegocioException;
import com.hospital.api.model.Convenio;
import com.hospital.api.repository.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConvenioService {
    @Autowired
    private ConvenioRepository convenioRepository;

    public List<ConvenioResponseDTO> listarTodos() {
        return convenioRepository.findAll()
                .stream()
                .map(ConvenioResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ConvenioResponseDTO buscarPorId(Long id) {
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convênio não encontrado: id=" + id));
        return new ConvenioResponseDTO(convenio);
    }

    public ConvenioResponseDTO salvar(ConvenioRequestDTO dto) {
        Convenio convenio = new Convenio();
        preencherDados(convenio, dto);
        return new ConvenioResponseDTO(convenioRepository.save(convenio));
    }

    public ConvenioResponseDTO atualizar(Long id, ConvenioRequestDTO dto) {
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Convênio não encontrado: id=" + id));
        preencherDados(convenio, dto);
        return new ConvenioResponseDTO(convenioRepository.save(convenio));
    }

    public void excluir(Long id) {
        if (!convenioRepository.existsById(id)) {
            throw new RegraNegocioException("Convênio não encontrado: id=" + id);
        }
        convenioRepository.deleteById(id);
    }

    private void preencherDados(Convenio convenio, ConvenioRequestDTO dto) {
        convenio.setNome(dto.getNome());
        convenio.setCodigo(dto.getCodigo());
        convenio.setDescricao(dto.getDescricao());
    }
}
