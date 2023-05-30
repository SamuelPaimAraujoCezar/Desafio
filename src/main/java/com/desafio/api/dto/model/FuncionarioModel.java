package com.desafio.api.dto.model;

import com.desafio.infrastructure.dto.GenericModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
public class FuncionarioModel extends GenericModel {

    private String nome;

    private String cargo;

    private String departamento;

    private LocalDate dataAdmissao;

    private Double salario;

    private String contato;

}
