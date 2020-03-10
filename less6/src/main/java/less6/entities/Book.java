package less6.entities;

import javax.persistence.*;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "idBook")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "releaseDate")
    private String dated;

    @Column(name = "link_image")
    private String link_image;

    public String getLink_image() {
        return link_image;
    }

    public void setLink_image(String link_image) {
        this.link_image = link_image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getDate(){
        return dated.toString();
    }

    public void setDated(String date){
        dated=date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDated() {
        return dated;
    }


    public Book() {
    }


}
