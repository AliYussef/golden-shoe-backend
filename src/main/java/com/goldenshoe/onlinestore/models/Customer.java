package com.goldenshoe.onlinestore.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by aliyussef on 24/04/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "firstName may not be empty")
    @Size(min = 2, max = 32, message = "firstName must be between 2 and 32 characters long")
    private String firstName;

    @NotEmpty(message = "lastName may not be empty")
    @Size(min = 2, max = 32, message = "lastName must be between 2 and 32 characters long")
    private String lastName;

    @Email
    @NotEmpty(message = "email may not be empty")
    private String email;

    @NotEmpty(message = "phoneNumber may not be empty")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Address> addresses;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
