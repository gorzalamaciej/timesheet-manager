package pl.bestapp.timesheetmanager.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.bestapp.timesheetmanager.dto.response.TaskResponse;
import pl.bestapp.timesheetmanager.service.TaskService;


@AllArgsConstructor
@RestController("/api/task")
public class TaskController {

    private TaskService taskService;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTasksById(@PathVariable Long id) {
        logger.info("Get task request: {}", id);
        return new ResponseEntity<>(taskService.getTasks(id), HttpStatus.OK);
    }

}
