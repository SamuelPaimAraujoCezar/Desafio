package com.desafio.domain.entity;

import com.desafio.infrastructure.entity.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "funcionarios")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Funcionario extends GenericEntity {

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
