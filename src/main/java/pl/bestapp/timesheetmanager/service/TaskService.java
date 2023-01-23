package pl.bestapp.timesheetmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bestapp.timesheetmanager.dto.response.TaskResponse;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskResponse getTasks(Long id) {
        return taskRepository.findById(id.intValue())
                .map(m -> TaskResponse.builder()
                        .name(m.getName())
                        .description(m.getDescription())
                        .createDate(m.getCreateDate())
                        .endOfWorkDate(m.getEndOfWorkDate())
                        .build())
                .orElse(null);
    }

}
