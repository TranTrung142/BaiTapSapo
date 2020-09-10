package com.sapo.service;

import com.sapo.dto.LoginDTO;
import com.sapo.dto.NewDTO;
import com.sapo.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {
    NewDTO save(NewDTO newDTO);
    //NewDTO update(NewDTO newDTO);
    void delete(Long[] ids) throws Exception;
    List<NewDTO> findAll(Pageable pageable);    //Pageable dung de phan trang
    List<NewDTO> findAll();     //get khong phan trang, ko can tham so
    List<NewDTO> findAll(String search);
    int totalItem();
    boolean login(LoginDTO loginDTO);
    NewDTO findNewById(Long id);

}
