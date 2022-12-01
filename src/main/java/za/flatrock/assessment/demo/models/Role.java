package za.flatrock.assessment.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Role")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Role implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Enumerated(EnumType.STRING)
    private RoleENUM role;

}
