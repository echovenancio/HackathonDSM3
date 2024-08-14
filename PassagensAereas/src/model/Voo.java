package model;
public class Voo {

    private String numeroVoo;
    private String origem;
    private String destino;
    private int assentosDisponiveis;

    public Voo(String numeroVoo, String origem, String destino, int assentosDisponiveis) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public boolean realizarReserva(int quantidadeAssentos) {

        if(verificarDisponibilidade(quantidadeAssentos)) {
            assentosDisponiveis -= quantidadeAssentos;
            System.out.println("Você realizou uma reserva");
            return true;

        }
        System.out.println("Assentos Indisponiveis");
        return false;

    }

    public boolean verificarDisponibilidade(int quantidadeAssentos) {
        return quantidadeAssentos <= assentosDisponiveis;
    }

    public double realizarPagamento(String tipoViagem, boolean pontoTuristicos) {
        double preco = 100;
        double precoTotal = 0;
        if(tipoViagem.equalsIgnoreCase("ida")) {
            precoTotal = preco;
        }else if (tipoViagem.equalsIgnoreCase(("ida e volta"))) {
            precoTotal = preco * 10000; // Capetalismo mesmo foudaci
        }else {
            System.out.println("Código Invalido");
            return 0;
        }

        if(pontoTuristicos) {
            precoTotal += 100000;
        }

        return precoTotal;
    }

    public void imprimirpassagem() {
        System.out.println("Numero do Voo: " + numeroVoo + " Origem do Voo: " + origem + " Destino da viagem: " + destino + " Assentos disponiveis: " +assentosDisponiveis);
    }

}