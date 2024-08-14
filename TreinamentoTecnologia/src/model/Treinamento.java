package model;
import java.util.ArrayList;

public class Treinamento {

    private int id;

    private String nomeInstrutor;

    private String linguagemEnsinada;

    private ArrayList<Aluno> alunos;

    private int cargaHoraria;

    private boolean disponibilidadeInstrutor;

    private static final int LIMITE_HORAS = 80;

    private static final int INTERVALO_MESES = 2;



    public class Aluno {

        private String nome;

        private double notaFinal;

        private ArrayList<Treinamento> historicoTreinamentos;



        public Aluno(String nome, double notaFinal) {

            this.nome = nome;

            this.notaFinal = notaFinal;

            this.historicoTreinamentos = new ArrayList<>();

        }



        public String getNome() {

            return nome;

        }



        public void setNome(String nome) {

            this.nome = nome;

        }



        public double getNotaFinal() {

            return notaFinal;

        }



        public void setNotaFinal(double notaFinal) {

            this.notaFinal = notaFinal;

        }



        public ArrayList<Treinamento> getHistoricoTreinamentos() {

            return historicoTreinamentos;

        }



        public void adicionarTreinamento(Treinamento treinamento) {

            historicoTreinamentos.add(treinamento);

        }



        public String toString() {

            return "Aluno{" + "nome='" + nome + '\'' + ", notaFinal=" + notaFinal + '}';

        }

    }



    public Treinamento(int id, String nomeInstrutor, String linguagemEnsinada) {

        this.id = id;

        this.nomeInstrutor = nomeInstrutor;

        this.linguagemEnsinada = linguagemEnsinada;

        this.alunos = new ArrayList<>();

        this.cargaHoraria = 0;

        this.disponibilidadeInstrutor = true;

    }

    public int getId() {

        return id;

    }



    public void setId(int id) {

        this.id = id;

    }



    public String getNomeInstrutor() {

        return nomeInstrutor;

    }



    public void setNomeInstrutor(String nomeInstrutor) {

        this.nomeInstrutor = nomeInstrutor;

    }



    public String getLinguagemEnsinada() {

        return linguagemEnsinada;

    }



    public void setLinguagemEnsinada(String linguagemEnsinada) {

        this.linguagemEnsinada = linguagemEnsinada;

    }



    public ArrayList<Aluno> getAlunos() {

        return alunos;

    }



    public void setAlunos(ArrayList<Aluno> alunos) {

        this.alunos = alunos;

    }



    public int getCargaHoraria() {

        return cargaHoraria;

    }



    public void setCargaHoraria(int cargaHoraria) {

        this.cargaHoraria = cargaHoraria;

    }



    public boolean isDisponibilidadeInstrutor() {

        return disponibilidadeInstrutor;

    }



    public void setDisponibilidadeInstrutor(boolean disponibilidadeInstrutor) {

        this.disponibilidadeInstrutor = disponibilidadeInstrutor;

    }



    public void adicionarAluno(String nome, double notaFinal) {

        Aluno aluno = new Aluno(nome, notaFinal);

        alunos.add(aluno);

        aluno.adicionarTreinamento(this);

    }



    public void removerAluno(String nome) {

        alunos.removeIf(aluno -> aluno.getNome().equals(nome));

    }



    public boolean verificarDisponibilidade() {

        return disponibilidadeInstrutor;

    }



    public void definirCargaHoraria(int horas) {

        this.cargaHoraria = horas;

    }



    public boolean verificarUltimoTreinamento(Aluno aluno) {

        if (aluno.getHistoricoTreinamentos().isEmpty()) {

            return true;

        }



        int totalHoras = aluno.getHistoricoTreinamentos().stream()

                .mapToInt(Treinamento::getCargaHoraria)

                .sum();

        return totalHoras + this.cargaHoraria <= LIMITE_HORAS;

    }



    public double calcularMediaAlunos() {

        if (alunos.isEmpty()) {

            return 0;

        }

        double somaNotas = alunos.stream()

                .mapToDouble(Aluno::getNotaFinal)

                .sum();

        return somaNotas / alunos.size();

    }



    public String toString() {

        return "Treinamento{" + "id=" + id + ", nomeInstrutor='" + nomeInstrutor + '\'' + ",   linguagemEnsinada='" + linguagemEnsinada + '\'' + ", cargaHoraria=" + cargaHoraria + ", disponibilidadeInstrutor=" + disponibilidadeInstrutor + ", alunos=" + alunos +

                '}';

    }
}