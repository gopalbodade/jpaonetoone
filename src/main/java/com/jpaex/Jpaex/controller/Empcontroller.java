package com.jpaex.Jpaex.controller;

import com.jpaex.Jpaex.model.Employee;
import com.jpaex.Jpaex.repository.EmpInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
public class Empcontroller {

    @Autowired
    EmpInterface empinterface;

    @RequestMapping(value="Savedata")
    ResponseEntity<?>saved(@RequestBody Employee e)
    {

        ResponseEntity<String>entity=null;
        empinterface.save(e);
        entity=new ResponseEntity<String>("saved",HttpStatus.OK);
        return entity;
    }

    @GetMapping("getdata/{id}")
    ResponseEntity<?>getD(@PathVariable int id)
    {
    Employee em=empinterface.findById(id);
    ResponseEntity<?> entity=ResponseEntity.ok(em);
    return entity;
    }

    @RequestMapping("delete/{id}")
    ResponseEntity<?>deleteData(@PathVariable int id)
    {
        ResponseEntity<String>entity=null;
        empinterface.delete(id);
        entity=new ResponseEntity<String>("delte",HttpStatus.OK);
        return  entity;

    }

   @GetMapping("update/{id}/{emailId}")
    ResponseEntity<?>updateTable(@PathVariable String emailId,
                                  @PathVariable int id)
    {


                Employee e=empinterface.findById(id);
                if(e!=null)
                {
                    e.setEmailId(emailId);
                }
                else{
                    return ResponseEntity.ok("Coustmer not found");
                }
              empinterface.save(e);
                ResponseEntity<?>entity=ResponseEntity.ok("saved");
                return entity;
    }




}
