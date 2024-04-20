package com.aton.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accountNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String inn;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER
    )
    private User responsibleUser;

    @JsonProperty
    @Enumerated(EnumType.STRING)
    private Status status;
}
