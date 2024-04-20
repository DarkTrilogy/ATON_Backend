package com.aton.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue
    @Column(name = "userid")
    private Integer userId;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "hashed_pwd")
    private String hashedPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole userRole;

    @JsonManagedReference
    @OneToMany(mappedBy = "responsibleUser", fetch = FetchType.EAGER)
    private List<Client> clients;
}
