package pl.bestapp.timesheetmanager.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bestapp.timesheetmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
