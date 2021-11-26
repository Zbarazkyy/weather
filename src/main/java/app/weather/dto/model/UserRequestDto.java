package app.weather.dto.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    @Pattern(regexp = "[^a-zA-Z0-9]+", message = "Password is not valid! ")
    @Size(min = 8)
    private String password;
}
