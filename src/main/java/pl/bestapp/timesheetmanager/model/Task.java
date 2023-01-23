package pl.bestapp.timesheetmanager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Size(max = 30)
    private String name;

    @Size(max = 1000)
    private String description;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "end_of_work_date")
    private Timestamp endOfWorkDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_employee",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
    private Set<Employee> employees;

}
