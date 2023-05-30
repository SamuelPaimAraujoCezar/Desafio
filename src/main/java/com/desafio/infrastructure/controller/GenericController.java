package com.desafio.infrastructure.controller;

import com.desafio.infrastructure.dto.*;
import com.desafio.infrastructure.entity.GenericEntity;
import com.desafio.infrastructure.repository.GenericRepository;
import com.desafio.infrastructure.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericController<Entity extends GenericEntity,
                                        EntityInput extends GenericInput,
                                        EntityModel extends GenericModel,
                                        EntityCollection extends GenericCollection,
                                        EntityMapper extends GenericMapper<Entity, EntityInput, EntityModel, EntityCollection>,
                                        Repository extends GenericRepository<Entity>,
                                        Service extends GenericService<Entity, Repository>> {

    @Autowired
    protected Service service;

    @Autowired
    protected EntityMapper entityMapper;

    @GetMapping
    public List<EntityCollection> listAll() {
        List<Entity> entities = service.listAll();

        return entities.stream()
                .map(entity -> entityMapper.mapEntityToCollection(entity))
                .collect(Collectors.toList());
    }

    @GetMapping("/{entityId}")
    public EntityModel find(@PathVariable Long entityId) {
        Entity entity = service.find(entityId);

        return entityMapper.mapEntityToModel(entity);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel create(@RequestBody @Valid EntityInput entityInput) {
        Entity entity = entityMapper.mapInputToEntity(entityInput);
        entity = service.create(entity);

        return entityMapper.mapEntityToModel(entity);
    }

    @PutMapping("/{entityId}")
    public EntityModel update(@PathVariable Long entityId, @RequestBody @Valid EntityInput entityInput) {
        Entity entity = service.verifyIfExists(entityId);
        entityMapper.copyInputToEntity(entityInput, entity);
        entity = service.update(entity);

        return entityMapper.mapEntityToModel(entity);
    }

    @DeleteMapping("/{entityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long entityId) {
        service.verifyIfExists(entityId);
        service.delete(entityId);
    }

}
