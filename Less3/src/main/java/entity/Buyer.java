package entity;

import antlr.LexerSharedInputState;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "buyer")
public class Buyer implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buyer")
    private int id;

    @Column(name = "nameBuyer")
    private String nameBuyer;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "backet", // название таблицы
            joinColumns = @JoinColumn(name = "id_buyer"),  // то что связываем
            inverseJoinColumns = @JoinColumn(name = "id_Products") // то на что связываем
    )


    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String allProduct = "";
        for (Product o : products) {
            allProduct += o.getTitle() + " ";
        }
        return nameBuyer + " Купил: " + allProduct + ".";
    }
}
