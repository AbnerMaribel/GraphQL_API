package com.amaribel.GraphQL.controller;

import com.amaribel.GraphQL.model.Coffee;
import com.amaribel.GraphQL.service.CoffeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Controller
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @QueryMapping
    public List<Coffee> findAll() {
        return coffeeService.findAll();
    }

    @QueryMapping
    public Optional<Coffee> findById(@Argument Integer id) {
        return coffeeService.findOne(id);
    }
}
