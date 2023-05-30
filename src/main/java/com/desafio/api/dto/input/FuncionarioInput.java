package com.desafio.api.dto.input;

import com.desafio.infrastructure.dto.GenericInput;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
public class FuncionarioInput extends GenericInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String cargo;

    @NotBlank
    private String departamento;

    @NotNull
    private LocalDate dataAdmissao;

    @NotNull
    private Double salario;

    @NotBlank
    private String contato;

}
