package ir.mrmoein.demo2.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseModel<ID> implements Serializable {
    @Id
    private ID id;
}
