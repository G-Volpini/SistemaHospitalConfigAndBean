package com.hospital.api.controller;

import com.hospital.api.dto.ConvenioRequestDTO;
import com.hospital.api.dto.ConvenioResponseDTO;
import com.hospital.api.service.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenios")
@CrossOrigin(origins = "*")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    @GetMapping
    public List<ConvenioResponseDTO> listar() {
        return convenioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvenioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(convenioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ConvenioResponseDTO> cadastrar(@RequestBody @Valid ConvenioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(convenioService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConvenioResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ConvenioRequestDTO dto) {
        return ResponseEntity.ok(convenioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        convenioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
