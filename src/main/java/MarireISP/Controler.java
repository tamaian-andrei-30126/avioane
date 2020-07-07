package MarireISP;

public class Controler {
    private Macaz macaz;

    public Controler(Macaz macaz) {
        this.macaz = macaz;
    }
    public void comutaMacaz(Macaz m){
        System.out.println("Macazul "+m.toString()+" a fost comutat.");
    }
}
