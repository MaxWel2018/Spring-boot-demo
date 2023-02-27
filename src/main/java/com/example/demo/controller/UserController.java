package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.service.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class UserController {

    /*
     * http://localhost:8080/home
     *
     *
     *
     * */

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*GET request http://localhost:8080/home
     *
     *
     * http://localhost:8080/home/find
     *
     *
     * Read about @PathVariable  https://www.baeldung.com/spring-pathvariable
     * */
    @GetMapping("/find/{id}/get")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    /*POST request http://localhost:8080/home
     *
     * read about RequestBody https://www.baeldung.com/spring-request-response-body
     * */
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return user;

    }

    /*PUT request http://localhost:8080/home/123*/
    @PutMapping("{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("{idForDelete}")
    public void deleteUser(@PathVariable(name = "idForDelete") String id) {
        throw new UnsupportedOperationException();
    }
}
