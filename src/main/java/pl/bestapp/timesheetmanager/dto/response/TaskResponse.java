package pl.bestapp.timesheetmanager.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class TaskResponse {

    private String name;
    private String description;
    private Date createDate;
    private Date endOfWorkDate;

}
