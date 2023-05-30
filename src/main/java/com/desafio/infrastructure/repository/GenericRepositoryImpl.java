package com.desafio.infrastructure.repository;

import com.desafio.infrastructure.entity.GenericEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class GenericRepositoryImpl<Entity extends GenericEntity> extends SimpleJpaRepository<Entity, Long>
        implements IGenericRepository<Entity> {

    private EntityManager entityManager;

    public GenericRepositoryImpl(JpaEntityInformation<Entity, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
    }

    @Override
    public void detach(Entity entity) {
        entityManager.detach(entity);
    }

}
