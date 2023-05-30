package com.desafio.api.dto.mapper;

import com.desafio.api.dto.collection.FuncionarioCollection;
import com.desafio.api.dto.input.FuncionarioInput;
import com.desafio.api.dto.model.FuncionarioModel;
import com.desafio.domain.entity.Funcionario;
import com.desafio.infrastructure.dto.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper extends GenericMapper<Funcionario, FuncionarioInput, FuncionarioModel, FuncionarioCollection> {

    public FuncionarioMapper() {
        super(Funcionario.class, FuncionarioInput.class, FuncionarioModel.class, FuncionarioCollection.class);
    }

}
