package com.sapo.service.impl;

import com.sapo.converter.NewConverter;
import com.sapo.dto.LoginDTO;
import com.sapo.dto.NewDTO;
import com.sapo.entity.CategoryEntity;
import com.sapo.entity.NewEntity;
import com.sapo.entity.UserEntity;
import com.sapo.repository.CategoryRepository;
import com.sapo.repository.NewRepository;
import com.sapo.repository.UserRepository;
import com.sapo.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService  implements INewService{
    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        if(newDTO.getId() != null){ // newDTO co id => update
            NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());     //new cu
            newEntity = newConverter.toEntity(newDTO,oldNewEntity);   //converter newDTO => oldNewEntity

        }else { //newDTO ko co id => them moi
            newEntity = newConverter.toEntity(newDTO);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode()); //tra ve id tu code
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);  //them moi
        return newConverter.toDTO(newEntity);
    }

    @Override
    public void delete(Long[] ids) throws Exception {
        for(Long id : ids){
            NewEntity newEntity = newRepository.findOne(id);
            if( newEntity == null) throw new NullPointerException("adc");
            newRepository.delete(id);
        }
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> result = new ArrayList<NewDTO>();
        List<NewEntity> newEntities = newRepository.findAll(pageable).getContent(); //lay list news
        for(NewEntity item : newEntities){
            result.add(newConverter.toDTO(item));
        }
        return result;
    }

    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> result = new ArrayList<NewDTO>();
        List<NewEntity> newEntities = newRepository.findAll(); //lay list news
        for(NewEntity item : newEntities){
            result.add(newConverter.toDTO(item));
        }
        return result;
    }

    @Override
    public List<NewDTO> findAll(String search) {
        List<NewDTO> result = new ArrayList<NewDTO>();
        List<NewEntity> newEntities = newRepository.findByTitleContaining(search); //lay list news
        for(NewEntity item : newEntities){
            result.add(newConverter.toDTO(item));
        }
        return result;
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

    @Override
    public boolean login(LoginDTO loginDTO) {
        //UserEntity userEntity = new UserEntity();
        UserEntity userEntity = userRepository.findOneByUserName(loginDTO.getUser());
        if(userEntity == null){
            return false;
        }else {
            if(userEntity.getPassword().equals(loginDTO.getPassword())){
                return true;
            }
            return false;
        }

    }

    @Override
    public NewDTO findNewById(Long id) {
        NewEntity newEntity ;
        newEntity = newRepository.findOne(id);
//        if(newEntity == null){
//            return null;
//        }
        //dto.setCategoryCode(categoryRepository.findOne(entity.));
        NewDTO newDTO = newConverter.toDTO(newEntity);
        newDTO.setCategoryCode(newEntity.getCategory().getCode());
        return newDTO;
    }

    /*
    @Override
    public NewDTO update(NewDTO newDTO) {
        NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());     //new cu
        NewEntity newEntity = newConverter.toEntity(newDTO,oldNewEntity);   //converter
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);  //cap nhap, update
        return newConverter.toDTO(newEntity);
    }*/
}
