package ru.gb.jSilver.spring.market.products.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.jSilver.spring.market.api.ProductDto;

import javax.persistence.*;

@Entity
@Table(name = "orders_products")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_product")
    private int pricePerProduct;

    @Column(name = "price")
    private int price;

    public OrderItem(Order order, ProductEntity product, int quantity, int pricePerProduct, int price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.pricePerProduct = pricePerProduct;
        this.price = price;
    }
}
