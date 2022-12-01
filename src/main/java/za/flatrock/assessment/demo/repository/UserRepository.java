package za.flatrock.assessment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.flatrock.assessment.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNameAndSurnameAndPhoneNumber(String name, String surname,String phoneNumber);

}
