package com.amaribel.GraphQL.controller;

import com.amaribel.GraphQL.model.Coffee;
import com.amaribel.GraphQL.model.Size;
import com.amaribel.GraphQL.service.CoffeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

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

    @Secured("ROLE_USER")
    @QueryMapping(value = "allCoffee")
    public Optional<Coffee> findById(@Argument Integer id) {
        return coffeeService.findOne(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping(value = "createCoffee")
    public Coffee create(@Argument String name, @Argument Size size) {
        return coffeeService.create(name, size);
    }
}
