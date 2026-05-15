package com.hospital.api.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Receitas")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String descricao;

    @Column
    private String medicamentos;

    @Column
    private String data;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getMedicamentos() { return medicamentos; }
    public void setMedicamentos(String medicamentos) { this.medicamentos = medicamentos; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public Consulta getConsulta() { return consulta; }
    public void setConsulta(Consulta consulta) { this.consulta = consulta; }
}
