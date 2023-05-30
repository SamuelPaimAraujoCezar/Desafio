package com.desafio.infrastructure.service;

import com.desafio.infrastructure.entity.GenericEntity;
import com.desafio.domain.exception.ResourceInUseException;
import com.desafio.domain.exception.ResourceNotFoundException;
import com.desafio.infrastructure.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class GenericService<Entity extends GenericEntity, Repository extends GenericRepository<Entity>> {

    @Autowired
    protected Repository repository;

    private Class<Entity> entityClass;

    public GenericService(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    public List<Entity> listAll() {
        return repository.findAll();
    }

    public Entity find(Long entityId) {
        return verifyIfExists(entityId);
    }

    protected Entity save(Entity entity) {
        return repository.save(entity);
    }

    @Transactional
    public Entity create(Entity entity) {
        return save(entity);
    }

    @Transactional
    public Entity update(Entity entity) {
        return save(entity);
    }

    @Transactional
    public void delete(Long entityId) {
        try {
            repository.deleteById(entityId);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new ResourceInUseException(entityId, getResourceName());
        }
    }

    public Entity verifyIfExists(Long entityId) {
        return repository.findById(entityId)
                .orElseThrow(() -> new ResourceNotFoundException(entityId, getResourceName()));
    }

    protected String getResourceName() {
        return entityClass.getSimpleName();
    }

}
