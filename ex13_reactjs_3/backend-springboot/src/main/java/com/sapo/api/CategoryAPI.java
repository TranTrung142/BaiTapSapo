package com.sapo.api;

import com.sapo.dto.CategoryDTO;
import com.sapo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryAPI {
    @Autowired
    ICategoryService categoryService;

//    @DeleteMapping(value = "/sapo/category")
//    public void deleteCategory(@RequestBody Long id){
//        categoryService.deleteCategory(id);
//    }
//
//    @PostMapping(value = "/sapo/category")
//    public CategoryDTO postCategory(@RequestBody CategoryDTO model){
//        return categoryService.save(model);
//    }
//
//    @PutMapping(value = "sapo/category/{id}")
//    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO model, @PathVariable("id") Long id){
//        try{
//            model.setId(id);
//            return ResponseEntity.ok().body(categoryService.save(model));
//        }catch (Exception e){
//            return new ResponseEntity("Id does not exist!!!", HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping(value = "sapo/category")
    public ResponseEntity<?> getCategory(){
        try {
            return  ResponseEntity.ok().body(categoryService.getCategory());
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping(value = "/sapo/category/{id}")
    public ResponseEntity<?> getNewByCategory(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok().body(categoryService.getProductByCategory(id));
        }catch (Exception e){
            //e.printStackTrace();
            return new ResponseEntity("Id not found", HttpStatus.NOT_FOUND);
        }

    }

}
