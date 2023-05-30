package com.desafio.infrastructure.dto;

import com.desafio.infrastructure.entity.GenericEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericMapper<Entity extends GenericEntity,
                                    EntityInput extends GenericInput,
                                    EntityModel extends GenericModel,
                                    EntityCollection extends GenericCollection> {

    @Autowired
    protected ModelMapper modelMapper;

    private Class<Entity> entityClass;
    private Class<EntityInput> entityInputClass;
    private Class<EntityModel> entityModelClass;
    private Class<EntityCollection> entityCollectionClass;

    public GenericMapper(Class<Entity> entityClass, Class<EntityInput> entityInputClass,
                         Class<EntityModel> entityModelClass, Class<EntityCollection> entityCollectionClass) {
        this.entityClass = entityClass;
        this.entityInputClass = entityInputClass;
        this.entityModelClass = entityModelClass;
        this.entityCollectionClass = entityCollectionClass;
    }

    public EntityModel mapEntityToModel(Entity entity) {
        return modelMapper.map(entity, entityModelClass);
    }

    public EntityCollection mapEntityToCollection(Entity entity) {
        return modelMapper.map(entity, entityCollectionClass);
    }

    public Entity mapInputToEntity(EntityInput entityInput) {
        return modelMapper.map(entityInput, entityClass);
    }

    public void copyInputToEntity(EntityInput entityInput, Entity entity) {
        modelMapper.map(entityInput, entity);
    }

}
