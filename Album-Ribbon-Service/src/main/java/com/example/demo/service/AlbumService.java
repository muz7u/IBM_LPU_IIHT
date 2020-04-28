package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {

    @Autowired
    RestTemplate restTemplate;

    public List<Object> getAllService() {
        return restTemplate.getForObject("http://IMAGE-SERVICE/getAll",List.class);
    }
    
 //   public void addImageService()
 //   {
 //   	restTemplate.postForObject("http://IMAGE-SERVICE/images", objImage, Class);
 //  }

}
