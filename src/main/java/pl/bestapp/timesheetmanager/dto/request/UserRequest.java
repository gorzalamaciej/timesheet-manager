package pl.bestapp.timesheetmanager.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
}
