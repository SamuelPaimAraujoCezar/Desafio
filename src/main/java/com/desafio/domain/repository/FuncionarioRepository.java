package com.desafio.domain.repository;

import com.desafio.domain.entity.Funcionario;
import com.desafio.infrastructure.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends GenericRepository<Funcionario> {

}
