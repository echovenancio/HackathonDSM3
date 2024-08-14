package model;
class TreinamentoOnline extends Treinamento {

    private String linkAcesso;



    public TreinamentoOnline(int id, String nomeInstrutor, String linguagemEnsinada, String linkAcesso) {

        super(id, nomeInstrutor, linguagemEnsinada);

        this.linkAcesso = linkAcesso;

    }



    public String getLinkAcesso() {

        return linkAcesso;

    }



    public void setLinkAcesso(String linkAcesso) {

        this.linkAcesso = linkAcesso;

    }



    public void mostrarDetalhes() {

        System.out.println("Treinamento Online:");

        System.out.println("ID: " + getId());

        System.out.println("Instrutor: " + getNomeInstrutor());

        System.out.println("Linguagem: " + getLinguagemEnsinada());

        System.out.println("Link de Acesso: " + linkAcesso);

        System.out.println("Carga Horária: " + getCargaHoraria());

        System.out.println("Disponibilidade do Instrutor: " + isDisponibilidadeInstrutor());

        System.out.println("Alunos: " + getAlunos());

    }

}