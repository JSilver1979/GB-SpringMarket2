package ru.gb.jSilver.spring.market.products.data;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    public ProductEntity(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

}
