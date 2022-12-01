package za.flatrock.assessment.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.flatrock.assessment.demo.exceptions.UserNotFoundException;
import za.flatrock.assessment.demo.models.CreateUserRequest;
import za.flatrock.assessment.demo.models.CreateUserResponse;
import za.flatrock.assessment.demo.models.DeleteUserResponse;
import za.flatrock.assessment.demo.models.User;
import za.flatrock.assessment.demo.services.CreateUserService;
import za.flatrock.assessment.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserService createUserService;
    private UserService userService;
    @Autowired
    private DeleteUserResponse deleteUserResponse;
    @Autowired
    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }
    /*For testing purposes*/
    @GetMapping("/")
    public String welcome(){
        return "Welcome to my api: testing 1,2 1,2";
    }
    /*A method that creates a new user given an input body*/
    @PatchMapping(value = "/create")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        return createUserService.create(createUserRequest);
    }
    /*Returns an object based on name,surname or cellphone number*/
    @PostMapping(value = "/search")
    public User search(@RequestBody User user)throws UserNotFoundException {
        return userService.search(user);
    }

    //Deletes the object with the id that equals the id that would come from the url
    @DeleteMapping(value = "/departments/{id}")
    public DeleteUserResponse deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        deleteUserResponse= new DeleteUserResponse();
        deleteUserResponse.setSuccess(true);
        return deleteUserResponse;
    }

    //Takes the request body with the new role field as input and updates the table with a new field
    @PutMapping("/update")
    public User updateDepartment(@RequestBody User user) {
        return userService.updateRole(user);
    }
}

