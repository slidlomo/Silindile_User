package za.flatrock.assessment.demo.services;

import za.flatrock.assessment.demo.exceptions.UserNotFoundException;
import za.flatrock.assessment.demo.models.User;

public interface UserService {
    public void deleteUser(Long departmentId);

    public User updateRole(User user);
    public User search(User user);



}
