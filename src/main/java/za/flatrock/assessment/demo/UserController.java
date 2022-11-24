package za.flatrock.assessment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.flatrock.assessment.demo.models.CreateUserRequest;
import za.flatrock.assessment.demo.models.CreateUserResponse;
import za.flatrock.assessment.demo.models.DeleteUserResponse;
import za.flatrock.assessment.demo.services.CreateUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserService createUserService;

    @Autowired
    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PatchMapping(value = "/create")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        return createUserService.create(createUserRequest);
    }

    @PostMapping(value = "/delete/{id}")
    public DeleteUserResponse deleteUser(@PathVariable Long id) {
        return null;
    }
}
