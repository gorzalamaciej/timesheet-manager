package pl.bestapp.timesheetmanager.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class UserResponse {
    private int id;
    private String email;
    private String name;
    private String lastName;
    private boolean active;
}
