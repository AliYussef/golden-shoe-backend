package com.goldenshoe.onlinestore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
@Table(name = "addresses")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "streetName may not be empty")
    @Size(min = 2, max = 32, message = "streetName must be between 2 and 32 characters long")
    private String streetName;

    @NotEmpty(message = "houseNumber may not be empty")
    private String houseNumber;

    @NotEmpty(message = "zipcode may not be empty")
    @Size(min = 2, max = 32, message = "zipcode must be between 2 and 32 characters long")
    private String zipcode;

    @NotEmpty(message = "city may not be empty")
    @Size(min = 2, max = 32, message = "city must be between 2 and 32 characters long")
    private String city;

    @NotEmpty(message = "country may not be empty")
    @Size(min = 2, max = 32, message = "country must be between 2 and 32 characters long")
    private String country;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "billingAddress", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "shippingAddress", fetch = FetchType.LAZY)
    private Set<Order> orders2;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
