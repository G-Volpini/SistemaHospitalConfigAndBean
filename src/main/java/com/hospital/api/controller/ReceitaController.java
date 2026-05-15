package com.hospital.api.controller;

import com.hospital.api.dto.ReceitaRequestDTO;
import com.hospital.api.dto.ReceitaResponseDTO;
import com.hospital.api.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
@CrossOrigin(origins = "*")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public List<ReceitaResponseDTO> listar() {
        return receitaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(receitaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ReceitaResponseDTO> cadastrar(@RequestBody @Valid ReceitaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ReceitaRequestDTO dto) {
        return ResponseEntity.ok(receitaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        receitaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
