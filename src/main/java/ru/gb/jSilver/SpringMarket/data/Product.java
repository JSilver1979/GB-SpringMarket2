package ru.gb.jSilver.SpringMarket.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    public Product(String title, Integer price) {
        this.title = title;
        this.price = price;
    }
}
