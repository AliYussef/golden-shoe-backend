package com.goldenshoe.onlinestore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "billingAddress", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @OneToMany(mappedBy = "shippingAddress", fetch = FetchType.LAZY)
    private Set<Order> orders2;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
