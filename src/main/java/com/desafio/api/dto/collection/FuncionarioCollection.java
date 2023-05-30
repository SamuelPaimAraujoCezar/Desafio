package com.desafio.api.dto.collection;

import com.desafio.infrastructure.dto.GenericCollection;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
public class FuncionarioCollection extends GenericCollection {

    private String nome;

    private String cargo;

    private String departamento;

    private LocalDate dataAdmissao;

    private Double salario;

    private String contato;

}
