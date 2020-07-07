package MarireISP;

public class Operator {
    public static void main(String[] args) {
        Macaz m=new Macaz("Andrei");
        Controler c1 = new Controler(m);
        c1.comutaMacaz(m);
    }
}
