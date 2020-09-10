package com.sapo.converter;

import com.sapo.dto.NewDTO;
import com.sapo.entity.NewEntity;
import com.sapo.repository.CategoryRepository;
import com.sapo.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {
    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //converter NewDTO -> NewEntity
    public NewEntity toEntity(NewDTO dto){
        NewEntity entity = new NewEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }
    //converter NewEntity -> NewDTO
    public NewDTO toDTO(NewEntity entity){
        NewDTO dto = new NewDTO();
        if(entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setShortDescription(entity.getShortDescription());
        dto.setThumbnail(entity.getThumbnail());

        //dto.setCategoryCode(entity.getCategory().getCode());

        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public NewEntity toEntity(NewDTO dto, NewEntity entity){
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }
}
