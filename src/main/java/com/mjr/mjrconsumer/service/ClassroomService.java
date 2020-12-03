package com.mjr.mjrconsumer.service;

import com.mjr.mjrconsumer.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${resource.url}")
    private String resource;
    @Value("${resource.url}/{id}")
    private String idResource;

    public List<Classroom> findAll(){
        return Arrays.stream(restTemplate.getForObject(resource + "/classrooms", Classroom[].class)).collect(Collectors.toList());
    }

    public Classroom findById(Integer id) {
        return restTemplate.getForObject(resource + "/classrooms/ " + id,Classroom.class);
    }

    public Classroom create(Classroom classroom) {
        return restTemplate.postForObject(resource + "/classrooms", classroom, Classroom.class);
    }

    public Classroom update(Integer id, Classroom classroom) {
        return restTemplate.exchange(resource + "/classrooms/" + id, HttpMethod.PUT, new HttpEntity<>(classroom), Classroom.class).getBody();
    }
}
