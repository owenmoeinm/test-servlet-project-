package ir.mrmoein.demo2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;


import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
public class UserModel extends BaseModel<UUID> {
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

    @Temporal(TemporalType.DATE)
    private LocalDate createDate;
}