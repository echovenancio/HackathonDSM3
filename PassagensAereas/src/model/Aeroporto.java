package model;
import java.util.ArrayList;

public class Aeroporto {

    private ArrayList<Voo> voos;

    public Aeroporto() {
        this.voos = new ArrayList<>();
    }

    public void adicionarVoo(Voo voo) {
        voos.add(voo);
    }

    public void removerVoo(Voo voo) {
        voos.remove(voo);
    }

    public void exibirVoos() {
        System.out.println("Todos os voos: " + voos);
        for (Voo voo : voos) {
            System.out.println("Número do voo: " + voo.getNumeroVoo());
        }
    }

}