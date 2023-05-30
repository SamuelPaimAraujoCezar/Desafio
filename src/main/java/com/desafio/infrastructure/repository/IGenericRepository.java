package com.desafio.infrastructure.repository;

import com.desafio.infrastructure.entity.GenericEntity;

public interface IGenericRepository<Entity extends GenericEntity> {

    void detach(Entity entity);

}
