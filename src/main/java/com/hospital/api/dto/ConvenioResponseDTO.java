package com.hospital.api.dto;
import com.hospital.api.model.Convenio;

public class ConvenioResponseDTO {
    private Long id;
    private String nome;
    private String codigo;
    private String descricao;

    public ConvenioResponseDTO(Convenio convenio) {
        this.id = convenio.getId();
        this.nome = convenio.getNome();
        this.codigo = convenio.getCodigo();
        this.descricao = convenio.getDescricao();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public String getDescricao() { return descricao; }
}
