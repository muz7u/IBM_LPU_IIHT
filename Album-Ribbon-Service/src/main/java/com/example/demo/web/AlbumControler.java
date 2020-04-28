package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AlbumService;

@RestController
public class AlbumControler {



    @Autowired
    AlbumService imageService;

    @RequestMapping("/getAll")
    public List<Object> getAllImages(){
        return imageService.getAllService();
    }


}
