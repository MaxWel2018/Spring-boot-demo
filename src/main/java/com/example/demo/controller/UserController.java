package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.service.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find/all")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/find/{name}")
    public User findUserByName(@PathVariable String name){
        return userService.findByName(name);
    }


    /*POST request http://localhost:8080/home
     *
     * read about RequestBody https://www.baeldung.com/spring-request-response-body
     * */
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    /*PUT request http://localhost:8080/home/123*/
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
       try {
           return userService.updateUser(id, user);
       }catch (IndexOutOfBoundsException e){
           throw new IllegalArgumentException("Not valid index value");
       }
    }

    @DeleteMapping("/delete/{idForDelete}")
    public void deleteUser(@PathVariable(name = "idForDelete") String id) {
        userService.deleteById(id);
    }
}
