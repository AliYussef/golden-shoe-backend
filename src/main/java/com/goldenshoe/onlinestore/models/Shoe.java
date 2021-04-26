package com.goldenshoe.onlinestore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
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
@Table(name = "shoes")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name may not be empty")
    @Size(min = 2, message = "name must be at least 2 characters long")
    private String name;

    @NotEmpty(message = "brand may not be empty")
    @Size(min = 2, message = "brand must be at least 2 characters long")
    private String brand;

    @OneToMany(mappedBy = "shoe", fetch = FetchType.LAZY)
    private Set<ShoeVariant> shoeVariants;

    @Builder.Default
    @ManyToMany(mappedBy = "shoes", fetch = FetchType.LAZY)
    private Set<Category> categories = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private ShoeTarget target;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
