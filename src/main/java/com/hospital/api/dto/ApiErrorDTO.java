package com.hospital.api.dto;
import java.util.Arrays;
import java.util.List;

public class ApiErrorDTO {
    private List<String> erros;

    public ApiErrorDTO(String mensagem) {
        this.erros = Arrays.asList(mensagem);
    }

    public ApiErrorDTO(List<String> erros) {
        this.erros = erros;
    }

    public List<String> getErros() {
        return erros;
    }
}
