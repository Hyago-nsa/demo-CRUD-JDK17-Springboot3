package com.example.demoCRUD.controllers;


import com.example.demoCRUD.dtos.DemoRecordDto;
import com.example.demoCRUD.models.DemoModel;
import com.example.demoCRUD.repositories.DemoReporitory;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoReporitory demoReporitory;

    @PostMapping("/products")
    public ResponseEntity<DemoModel> saveProduct(@RequestBody @Valid DemoRecordDto demoRecordDto){
        var demoModel = new DemoModel();
        BeanUtils.copyProperties(demoRecordDto, demoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(demoReporitory.save(demoModel));
    }
}