package com.test.hplus.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter @Setter
public class User {
    @Id
    private int id;

    @Size(min=6, message = "{username.requirements}")
    private String username;

    @Pattern(regexp = "((?=.*[A-Z]).{6,10})", message = "{password.requirements}")
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "{activity.warning}")
    private String activity;

    @NotEmpty(message = "{firstName.warning}")
    private String firstName;

    @NotEmpty(message = "{lastName.warning}")
    private String lastName;

    @NotNull(message = "{dateOfBirth.warning}")
    private Date dateOfBirth;

}
