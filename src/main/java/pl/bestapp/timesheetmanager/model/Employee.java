package pl.bestapp.timesheetmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Size(max = 50)
    private String name;

    @Size(max = 500)
    private String surname;

    @Size(max = 50)
    private String email;

    @Column(name = "password")
    @Size(max = 500)
    private String password;

    @Column(name = "available_date")
    private Timestamp availableDate;

    @Size(max = 50)
    private String role;

    private boolean activated;

    @ManyToMany(mappedBy = "employees")
    private Set<Task> tasks;

}
