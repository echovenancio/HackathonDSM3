package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {
    private int numero;
    private ArrayList<ItemPedido> items;
    private int mesa = -1;

    public Pedido(int numero, ItemPedido... items) {
        this.items = new ArrayList<>();
        this.numero = numero;
        this.items.addAll(Arrays.asList(items));
    }

    public ArrayList<ItemPedido> getItems() {
        return this.items;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getMesa() {
        return this.mesa;
    }

    public double totalPedido() {
        return this.items.stream()
                .reduce(0.0, (sum, item) -> Double.sum(sum,item.getPreco() * item.getQuantidade()), Double::sum);
    }

    public void adicionarItemPedido(ItemPedido item) {
       this.items.add(item);
    }

    public boolean removerPedido(ItemPedido item) {
        return this.items.remove(item);
    }

    public void reservarMesa(int nMesa) {
        this.mesa = nMesa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", items=" + items.toString() +
                ", mesa=" + mesa +
                '}';
    }
}
