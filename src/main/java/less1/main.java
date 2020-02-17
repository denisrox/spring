package less1;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        Sick sick = new Sick();
        sick.goToDoctor();
        MedicalCard card = new MedicalCard();
        sick.setCard(card);
        sick.goToDoctor();

        Registry reg = new Registry();
        sick = reg.getSick();
        sick.goToDoctor();

        System.out.println("===============Spring, XML=====================");

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Sick sick3 = context.getBean("sick", Sick.class);
        sick3.goToDoctor();

        Sick sick4 = context.getBean("sick", Sick.class);
        sick4.goToDoctor();

        System.out.println("===============Spring, Аннотация=====================");

        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        Sick sick5 = context2.getBean("sick", Sick.class);
        sick5.goToDoctor();

        Sick sick6 = context2.getBean("sick", Sick.class);
        sick6.goToDoctor();
    }
}
