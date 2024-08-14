package model;

class TreinamentoPresencial extends Treinamento {
    private String local;

    public TreinamentoPresencial(int id, String nomeInstrutor, String linguagemEnsinada, String local) {
        super(id, nomeInstrutor, linguagemEnsinada);
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void mostrarDetalhes() {
        System.out.println("Treinamento Presencial:");
        System.out.println("ID: " + getId());
        System.out.println("Instrutor: " + getNomeInstrutor());
        System.out.println("Linguagem: " + getLinguagemEnsinada());
        System.out.println("Local: " + local);
        System.out.println("Carga Horária: " + getCargaHoraria());
        System.out.println("Disponibilidade do Instrutor: " + isDisponibilidadeInstrutor());
        System.out.println("Alunos: " + getAlunos());
    }
}
