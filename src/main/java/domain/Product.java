package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Image> images;

    @ManyToMany
    @JoinTable(name = "product_cart",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "id")})
    private List<Cart> carts;

    @ManyToMany
    @JoinTable(name = "product_order",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    private List<Order> orders;

    public Product(){
        images = new ArrayList<>();
        carts = new ArrayList<>();
        orders = new ArrayList<>();
    }

}
