package com.example.test_case.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @Column(nullable = false, unique = true)
    private String emailAddress;

    @Pattern(regexp = "^(?=[^\\d_].*?\\d)\\w(\\w|[!@#$%]){7,20}")
    private String password;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Pattern(regexp = "(84|0[3|5|7|8|9])+(\\d{8})")
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Column(nullable = false,length = 400)
    private String address;

    @Column(length = 400)
    private String image;

    private Integer status;


    @ManyToOne(optional = false)
    private Role role;
}
