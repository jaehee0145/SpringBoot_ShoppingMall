package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String password;
private String phone;
private String email;

@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(name = "user_roles",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
private List<Role> roles;

@OneToMany(mappedBy = "user")
private List<Cart> carts;

@OneToMany(mappedBy = "user")
private List<Order> orders;

public User(){
    roles = new ArrayList<>();
    carts = new ArrayList<>();
    orders = new ArrayList<>();
}

}
