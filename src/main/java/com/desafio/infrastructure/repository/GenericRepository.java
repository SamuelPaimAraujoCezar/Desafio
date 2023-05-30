package com.desafio.infrastructure.repository;

import com.desafio.infrastructure.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<Entity extends GenericEntity> extends JpaRepository<Entity, Long>, IGenericRepository<Entity> {

}
