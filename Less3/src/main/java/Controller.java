import entity.Buyer;
import entity.IEntity;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class Controller {
    static SessionFactory factory;
    static Session session=null;

    private static void openFactory(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Buyer.class)
                .buildSessionFactory();
    }
    private static void closeSessionAndFactory(){
        factory.close();
        session.close();
    }

    public static void addProduct(String name, int cost){
        openFactory();

        try {
            //session = null;
            session = factory.getCurrentSession();
            Product tmpProduct = new Product();
            tmpProduct.setTitle(name);
            tmpProduct.setCost(cost);
            session.beginTransaction();
            session.save(tmpProduct);
            session.getTransaction().commit();
        } finally {
            closeSessionAndFactory();
        }
    }
    public static void addBuyer(String name){
        openFactory();
        try {
            //session = null;
            session = factory.getCurrentSession();
            Buyer tmpBuyer = new Buyer();
            tmpBuyer.setNameBuyer(name);
            session.beginTransaction();
            session.save(tmpBuyer);
            session.getTransaction().commit();
        } finally {
            closeSessionAndFactory();
        }
    }
    public static void deleteProduct(int id){
        openFactory();
        session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();


        } finally {
            closeSessionAndFactory();
        }
    }

    public static void deleteBuyer(int id){
        openFactory();
        session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.delete(buyer);
            session.getTransaction().commit();


        } finally {
            closeSessionAndFactory();
        }
    }

    public static void showProductsAtBuyer(int id){
        openFactory();
        session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            System.out.println(buyer);
            session.getTransaction().commit();


        } finally {
            closeSessionAndFactory();
        }
    }

    public static void showBuyerAtProducts(int id){
        openFactory();
        session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();


        } finally {
            closeSessionAndFactory();
        }
    }
}
