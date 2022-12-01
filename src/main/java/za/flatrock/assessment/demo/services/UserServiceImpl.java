package za.flatrock.assessment.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import za.flatrock.assessment.demo.exceptions.ErrorMessage;
import za.flatrock.assessment.demo.exceptions.UserNotFoundException;
import za.flatrock.assessment.demo.models.CreateUserRequest;
import za.flatrock.assessment.demo.models.CreateUserResponse;
import za.flatrock.assessment.demo.models.User;
import za.flatrock.assessment.demo.repository.UserRepository;
import za.flatrock.assessment.demo.utils.Validations;

import java.util.Objects;

public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    public Validations validations;

    public ErrorMessage errorMessage;

    /*Method that interacts with the repository with the help of the JPA Repository to
     create a user*/
    public CreateUserResponse create(CreateUserRequest createUserRequest) {
      String str= createUserRequest.getPhoneNumber();

      //Validate the phone number and return an error if incorrect
        if(!validations.validatePhoneNumber(str)){
            CreateUserResponse response = new CreateUserResponse();
            response.setErrorStatus(HttpStatus.BAD_REQUEST);
            response.setErrorMessage("Invalid cellphone number");
            return response;
        }
        else {
            User user = userRepository.save(new User(createUserRequest.getId(), createUserRequest.getName(), createUserRequest.getSurname(), createUserRequest.getPhoneNumber(), createUserRequest.getRole()));
            CreateUserResponse response = new CreateUserResponse();
            response.setId(user.getId());
            response.setName(user.getName());
            response.setSurname(user.getSurname());
            response.setSurname(user.getPhoneNumber());
            response.setSurname(user.getRole());
            return response;
        }
    }


    /*Method that interacts with the repository with the help of the JPA Repository to
     find a user*/
    public User search(User user){
        return userRepository.findByNameAndSurnameAndPhoneNumber(user.getName(),user.getSurname(),user.getPhoneNumber());
    }

    /*Method that interacts with the repository with the help of the JPA Repository to
     update a user*/
    @Override
    public User updateRole(User user) {
        User dB = userRepository.findByNameAndSurnameAndPhoneNumber(user.getName(), user.getSurname(), user.getPhoneNumber());
        String role= user.getRole();
        if(Objects.nonNull(role)){
            dB.setRole(role);
        }
        return userRepository.save(dB);
    }


    /*Method that interacts with the repository with the help of the JPA Repository to
     delete a user*/
    @Override
    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }

}
