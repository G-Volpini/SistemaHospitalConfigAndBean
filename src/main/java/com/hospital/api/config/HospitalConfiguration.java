package com.hospital.api.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.hospital.api.model.Consulta;
import com.hospital.api.model.Convenio;
import com.hospital.api.model.Medico;
import com.hospital.api.model.Paciente;
import com.hospital.api.model.Prontuario;
import com.hospital.api.model.Receita;

@Configuration
public class HospitalConfiguration {
    @Bean
    public Paciente pacientePadrao() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNome("João da Silva");
        paciente.setCpf("123.456.789-00");
        paciente.setEmail("joao.silva@email.com");
        paciente.setTelefone("(11) 99999-8888");
        paciente.setDataNascimento("1985-06-15");
        return paciente;
    }

    @Bean
    @Primary
    public Medico medicoCardiologista() {
        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNome("Dr. Carlos Souza");
        medico.setCrm("CRM/SP 123456");
        medico.setEspecialidade("Cardiologia");
        medico.setEmail("carlos.souza@hospital.com");
        return medico;
    }

    @Bean(name = "medicoClinicoGeral")
    public Medico medicoClinicoGeral() {
        Medico medico = new Medico();
        medico.setId(2L);
        medico.setNome("Dra. Ana Lima");
        medico.setCrm("CRM/SP 654321");
        medico.setEspecialidade("Clínica Geral");
        medico.setEmail("ana.lima@hospital.com");
        return medico;
    }

    @Bean
    public Convenio convenioPadrao() {
        Convenio convenio = new Convenio();
        convenio.setId(1L);
        convenio.setNome("Unimed");
        convenio.setCodigo("UNI-2025");
        convenio.setDescricao("Plano Premium - Cobertura Total");
        return convenio;
    }

    @Bean(name = "consultaCardiologia")
    public Consulta consultaCardiologia(
            Paciente pacientePadrao,
            Medico medicoCardiologista,
            Convenio convenioPadrao) {

        Consulta consulta = new Consulta();
        consulta.setId(1L);
        consulta.setData("2025-03-15");
        consulta.setObservacoes("Hipertensão leve controlada. Monitorar pressão semanalmente.");
        consulta.setPaciente(pacientePadrao);
        consulta.setMedico(medicoCardiologista);
        consulta.setConvenio(convenioPadrao);
        return consulta;
    }

    @Bean(name = "consultaClinicaGeral")
    public Consulta consultaClinicaGeral(
            Paciente pacientePadrao,
            @Qualifier("medicoClinicoGeral") Medico medicoClinicoGeral,
            Convenio convenioPadrao) {

        Consulta consulta = new Consulta();
        consulta.setId(2L);
        consulta.setData("2025-04-20");
        consulta.setObservacoes("Check-up anual sem alterações.");
        consulta.setPaciente(pacientePadrao);
        consulta.setMedico(medicoClinicoGeral);
        consulta.setConvenio(convenioPadrao);
        return consulta;
    }

    @Bean
    public Prontuario prontuarioPadrao(Paciente pacientePadrao) {
        Prontuario prontuario = new Prontuario();
        prontuario.setId(1L);
        prontuario.setDataAbertura("2025-01-10");
        prontuario.setHistorico(
                "Paciente com histórico de hipertensão leve. " +
                "Sem alergias conhecidas. Sem cirurgias anteriores."
        );
        prontuario.setPaciente(pacientePadrao);
        return prontuario;
    }

    @Bean
    public Receita receitaPadrao(@Qualifier("consultaCardiologia") Consulta consultaCardiologia) {
        Receita receita = new Receita();
        receita.setId(1L);
        receita.setData("2025-03-15");
        receita.setMedicamentos("Losartana 50mg");
        receita.setDescricao("Tomar 1 comprimido ao dia, pela manhã, com água.");
        receita.setConsulta(consultaCardiologia);
        return receita;
    }
}
