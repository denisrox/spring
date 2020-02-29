package entity;

import entity.Buyer;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product implements IEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Products")
    private int id;

    @Column(name = "cost")
    private int cost;

    @Column(name = "title_Products")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "backet", // название таблицы
            joinColumns = @JoinColumn(name = "id_Products"),  // то что связываем
            inverseJoinColumns = @JoinColumn(name = "id_buyer") // то на что связываем
    )
    private List<Buyer> buyers;

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    @Override
    public String toString() {
        String allBuyer = "";
        for (Buyer o : buyers) {
            allBuyer += o.getNameBuyer() + " ";
        }
        return title + " Купили: " + allBuyer + ".";
    }
}
