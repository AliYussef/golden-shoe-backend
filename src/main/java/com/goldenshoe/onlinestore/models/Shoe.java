package com.goldenshoe.onlinestore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by aliyussef on 24/04/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "shoes")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name may not be empty")
    @Size(min = 2, message = "name must be at least 2 characters long")
    private String name;

    @NotEmpty(message = "price may not be empty")
    @Min(1)
    private double price;

    private long stock;

    @NotEmpty(message = "brand may not be empty")
    @Size(min = 2, message = "brand must be at least 2 characters long")
    private String brand;

    @OneToMany(mappedBy = "shoe", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "shoe", fetch = FetchType.LAZY)
    private Set<Image> images;

    @ManyToMany
    @JoinTable(name = "shoes_sizes",
            joinColumns = @JoinColumn(name = "shoes_id", nullable = false, referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sizes_id", nullable = false, referencedColumnName = "id"))
    private Set<Size> sizes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "shoes_colors",
            joinColumns = @JoinColumn(name = "shoes_id", nullable = false, referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "colors_id", nullable = false, referencedColumnName = "id"))
    private Set<Color> colors = new HashSet<>();

    @ManyToMany(mappedBy = "shoes", fetch = FetchType.LAZY)
    private Set<Category> categories = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private ShoeTarget target;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
