package com.lucasalvess.datomicpoc.resource;

import com.lucasalvess.datomicpoc.model.Person;
import com.lucasalvess.datomicpoc.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonRepository repository;

    @PostMapping
    public Person create(@RequestBody Person person){
        return repository.save();
    }

    @GetMapping
    public void get(){
        repository.get();
    }
}
