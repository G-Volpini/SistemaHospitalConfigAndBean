package com.hospital.api.controller;

import com.hospital.api.dto.ProntuarioRequestDTO;
import com.hospital.api.dto.ProntuarioResponseDTO;
import com.hospital.api.service.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
@CrossOrigin(origins = "*")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @GetMapping
    public List<ProntuarioResponseDTO> listar() {
        return prontuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(prontuarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProntuarioResponseDTO> cadastrar(@RequestBody @Valid ProntuarioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prontuarioService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProntuarioRequestDTO dto) {
        return ResponseEntity.ok(prontuarioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        prontuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
