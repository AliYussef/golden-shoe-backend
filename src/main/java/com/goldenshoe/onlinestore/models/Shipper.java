package com.goldenshoe.onlinestore.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by aliyussef on 25/04/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "shippers")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name may not be empty")
    @Size(min = 2, message = "name must be at least 2 characters long")
    private String name;

    @Min(value = 1, message = "price should be bigger than 1")
    private double price;

    @OneToMany(mappedBy = "shipper", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
