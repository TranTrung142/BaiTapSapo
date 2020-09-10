package com.sapo.api;

import com.sapo.api.output.NewOutput;
import com.sapo.dto.LoginDTO;
import com.sapo.dto.NewDTO;
import com.sapo.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//dinh nghia 1 API
@RestController
public class NewAPI {
    @Autowired
    private INewService newService;

    //Loc new theo title, phan trang voi moi trang co toi da 10 ban ghi
    //( page la so trang hien tai, limit la so ban ghi toi da tren trang)
    @GetMapping(value = "/sapo/new")
    public NewOutput showNew( @RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "limit", required = false) Integer limit,
                                @RequestParam(value = "search", required = false) String search){
        NewOutput result = new NewOutput();
        if(search != null){
            result.setListResults(newService.findAll(search));
            return result;
        }
        if(page != null || limit != null){
            if(limit > 10) limit = 10;  //gioi han 1 trang toi da 10 ban ghi tra ve
            result.setPage(page);
            //offset la vi tri bat dau cua 1 page
            //offset = limit*(page-1)
            //listResults : offset => offset + limit -1
            Pageable pageable = new PageRequest(page - 1, limit);   //tinh offset
            result.setListResults(newService.findAll(pageable));
            result.setTotalPase((int) Math.ceil((double) (newService.totalItem()) / limit) );
        }else {
            result.setListResults(newService.findAll());
        }
        return result;
    }
    @GetMapping(value = "/sapo/new/{id}")
    public ResponseEntity<?> showNewById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok().body(newService.findNewById(id));
        }catch (Exception e){
            //e.printStackTrace();
            return new ResponseEntity("Id not found", HttpStatus.NOT_FOUND);
        }

    }

    //nhan request tu client vao server
    @PostMapping(value = "/sapo/new")
    // @ResponseBody tra ket qua json tu server ve client
    public NewDTO createNew(@RequestBody NewDTO model){     //@RequestBody nhan du lieu json duoc truyen thu client den server
        return newService.save(model);
    }

    @PutMapping(value = "/sapo/new/{id}")
    public ResponseEntity<?> updateNew(@RequestBody NewDTO model, @PathVariable("id") Long id){
        try {
            model.setId(id);
            return ResponseEntity.ok().body(newService.save(model));
        }catch (Exception e){
            return new ResponseEntity("Id does not exist", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping(value = "/sapo/new")
    public ResponseEntity<?> deleteNew(@RequestBody Long[] ids){
        try {
            newService.delete(ids);
            return ResponseEntity.ok().body("da xoa!!!!");
        }catch (Exception e){
            return new ResponseEntity("id not fond", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/sapo/login")
    public String  login(@RequestBody LoginDTO loginDTO){
        if(newService.login(loginDTO)==true){
            return "Login succesfull";
        }else {
            return "Login failed";
        }
    }
}
