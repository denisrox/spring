package entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    // INSERT INTO products (category_id, vendor_code, image, title, short_description, full_description, price)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Products")
    private Long id;


    @Column(name = "title_Products")
    private String title;


    @Column(name = "cost")
    private int cost;
}

