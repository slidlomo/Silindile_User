package za.flatrock.assessment.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.flatrock.assessment.demo.models.CreateUserRequest;
import za.flatrock.assessment.demo.models.CreateUserResponse;
import za.flatrock.assessment.demo.models.User;
import za.flatrock.assessment.demo.models.UserRepository;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;


    public CreateUserResponse create(CreateUserRequest createUserRequest) {
        User user = userRepository.save(new User(
                null,
                createUserRequest.getName(),
                createUserRequest.getSurname()
        ));
        CreateUserResponse response = new CreateUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setSurname(user.getSurname());

        return response;
    }

}
