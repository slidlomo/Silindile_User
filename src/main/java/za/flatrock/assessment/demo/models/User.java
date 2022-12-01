package za.flatrock.assessment.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
public class User {
   /* @EmbeddedId
    private Role role;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String name;

    private String surname;
    private String phoneNumber;
    private String role;


    public User() {
    }

    public User(Long id, String name, String surname,String phoneNumber,String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber= phoneNumber;
        this.role= role;
    }
}
