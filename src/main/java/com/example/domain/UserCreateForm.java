package com.example.domain;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class UserCreateForm {


    @NotEmpty(message = "{user.id}")
    @Size(max = 64)
    private String id;

    @NotEmpty
    @Size(max = 64)
    private String password1;
    private String password2;

    @NotEmpty
    private String gender;

    private Integer country;

    private List<Integer> skills;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("password1", password1)
                .add("password2", password2)
                .toString();
    }
}