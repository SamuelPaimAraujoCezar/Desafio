package com.desafio.domain.service;

import com.desafio.domain.entity.Funcionario;
import com.desafio.domain.repository.FuncionarioRepository;
import com.desafio.infrastructure.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService extends GenericService<Funcionario, FuncionarioRepository> {

    public FuncionarioService() {
        super(Funcionario.class);
    }

}
