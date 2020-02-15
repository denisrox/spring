package less1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.Random;

@Component("sick")
@Scope("prototype")
public class Sick {
    private int neededCabinet;
    private MedicalCard card;
    public Sick() {
        Random random = new Random();
        neededCabinet = random.nextInt(299)+1;
    }
    @Autowired
    public void setCard(MedicalCard card){
        this.card=card;
    }
    void goToDoctor(){
        if(card!=null)
            System.out.println("больной пришел в "+neededCabinet+" кабинет.");
        else
            System.out.println("у больного нет карты и он не знает куда идти");
    }

}
