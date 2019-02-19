package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "order")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    private String phone;
    private String adress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Order(){
        orderDate = new Date();

    }


}
