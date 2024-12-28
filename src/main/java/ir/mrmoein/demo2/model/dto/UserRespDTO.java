package ir.mrmoein.demo2.model.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class UserRespDTO {
    private UUID id;

    private String username;

    private String password;

    private String email;

    private LocalDate createDate;
}
