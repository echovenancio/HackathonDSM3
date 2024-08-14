package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Restaurante {
    private ArrayList<Pedido> pedidos;

    public Restaurante(Pedido... pedidos) {
        this.pedidos = new ArrayList<>();
        this.pedidos.addAll(Arrays.asList(pedidos));
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public boolean removerPedido(int nPedido) {
        return this.pedidos.removeIf(pedido -> pedido.getNumero() == nPedido);
    }

    public Optional<Pedido> getPedido(int nPedido) {
        for(Pedido pedido: this.pedidos) {
            if (pedido.getNumero() == nPedido) {
                return Optional.of(pedido);
            }
        }
        return Optional.empty();
    }

    public void exibirPedidos() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "pedidos=" + pedidos.toString() +
                '}';
    }
}

