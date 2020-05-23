package aut.utcluj.isp.ex4;

public class MainAndrei {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        ModelAndrei m = new ModelAndrei();
        ViewAndrei v = new ViewAndrei("MVC Heheh");
        ControllerAndrei c = new ControllerAndrei(m, v);
        c.initController();
    }

}
