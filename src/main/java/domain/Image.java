package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long length;
    private String saveFileName;
    private String mimeType;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
