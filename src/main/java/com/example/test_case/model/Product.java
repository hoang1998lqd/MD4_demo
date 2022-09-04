package com.example.test_case.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer status;

    private int discount;

//    @OneToMany(mappedBy = "product", cascade =  CascadeType.ALL)
//    @JsonManagedReference
//    private Set<ImageURL> imageURLS = new HashSet<>();
//    public Set<ImageURL> getImageURLS() {
//        return imageURLS;
//    }
//
//    public void setImageURLS(Set<ImageURL> imageURLS) {
//        this.imageURLS = imageURLS;
//    }

    //    @JsonIgnore
    @ManyToOne
    private Brand brand;

//    @JsonIgnore
    @ManyToOne
    private Category category;

}
