package MarireISP;

import java.util.List;

public class Gara {
    private List<Tren> trenuri;
    private List<Macaz> macazuri;
    private Controler controler;
    // Aici am vazut o greseala: un tren nu poate sa aiba mai multe gari si l-am facut in asa fel incat o gara sa aiba mai multe trenuri.

    public Gara(List<Tren> trenuri, List<Macaz> macazuri) {
        this.trenuri = trenuri;
        this.macazuri=macazuri;
    }

}
