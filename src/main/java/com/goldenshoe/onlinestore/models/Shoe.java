package com.goldenshoe.onlinestore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private String name;
    private double price;
    private long stock;
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

    @Enumerated(value = EnumType.STRING)
    private ShoeTarget target;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
