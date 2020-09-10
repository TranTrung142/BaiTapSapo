package com.sapo.api;

import com.sapo.api.output.Pagination;
import com.sapo.dto.CategoryDTO;
import com.sapo.entity.CategoryEntity;
import com.sapo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryAPI {
    @Autowired
    ICategoryService categoryService;

    @GetMapping(value = "sapo/category")
    public ResponseEntity<?> getCategory(@RequestParam(value = "page", required = false) Integer page,
                                         @RequestParam(value = "limit", required = false) Integer limit
    ){
        try {
            Pagination pagination = new Pagination();
            if(page != null && limit != null){
                pagination.setPage(page);
                Pageable pageable = new PageRequest(page - 1, limit);
                pagination.setListCategory(categoryService.pagination(pageable));
                pagination.setTotalPage( (int) Math.ceil((double) (categoryService.totalCategory()) / limit));
            }else {
                pagination.setListCategory(categoryService.getCategory());
            }
            return  ResponseEntity.ok().body(pagination);
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

    @PostMapping(value = "/sapo/category")
    public ResponseEntity<?> postCategory(@RequestBody CategoryEntity category){
        try{
            categoryService.saveCategory(category);
            return ResponseEntity.ok().body("save success");
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/sapo/category/{id}")
    public ResponseEntity<?> putCategory(@RequestBody CategoryEntity category,
                                         @PathVariable("id") Long id){
        try{
            categoryService.updateCategory(category, id);
            return ResponseEntity.ok().body("update success");
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/sapo/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
        try{
            categoryService.deleteCategory(id);
            return ResponseEntity.ok().body("delete success");
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
