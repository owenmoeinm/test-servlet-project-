package ir.mrmoein.demo2.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
public class UserReqDTO {

    @NotBlank
    @Length(min = 1 , max = 20)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Length(min = 4 , max = 10)
    private String password;

    @Email
    @NotBlank
    private String email;

}
