package com.goldenshoe.onlinestore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Set;

/**
 * Created by aliyussef on 26/04/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_variants")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "price should be bigger than 1")
    private double price;

    private long stock;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @JsonIgnore
    @OneToMany(mappedBy = "productVariant", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "productVariant", fetch = FetchType.LAZY)
    private Set<Image> images;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

}
