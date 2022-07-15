package com.kepco.etax.api.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "이름은 널값을 허용하지 않습니다.")
    private String name;

    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{11}$")
    private String mobile;

    private String gender;

    @Min(18)
    @Max(80)
    private int age;
    private String nationality;

}
