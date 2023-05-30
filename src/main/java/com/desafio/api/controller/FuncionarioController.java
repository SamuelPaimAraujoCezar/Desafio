package com.desafio.api.controller;

import com.desafio.api.dto.collection.FuncionarioCollection;
import com.desafio.api.dto.input.FuncionarioInput;
import com.desafio.api.dto.mapper.FuncionarioMapper;
import com.desafio.api.dto.model.FuncionarioModel;
import com.desafio.domain.entity.Funcionario;
import com.desafio.domain.repository.FuncionarioRepository;
import com.desafio.domain.service.FuncionarioService;
import com.desafio.infrastructure.controller.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController extends GenericController<Funcionario, FuncionarioInput, FuncionarioModel, FuncionarioCollection, FuncionarioMapper, FuncionarioRepository, FuncionarioService> {
}
