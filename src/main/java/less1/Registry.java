package less1;

public class Registry {
    public Sick getSick(){
        Sick sick = new Sick();
        MedicalCard card = new MedicalCard();
        sick.setCard(card);
        return sick;
    }
}
