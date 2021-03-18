package com.example.calcularnota;

public class Alunos {
    private String nomeAluno;
    private Double notas[] = new Double[3];

    public Alunos(String nomeAluno, Double notas[]){
        super();
        this.nomeAluno = nomeAluno;
        this.notas = notas;
    }

    public Double calculaNota(){
        return ((notas[0]+notas[1]+notas[2]+notas[3])/4);
    }

    public String statusAluno(Double media){
        if (media >= 6) {return ("Aprovado");}
        else if (media < 6 & media>4){return("Verificação Suplementar");}
        else {return("Reprovado");}
    }

    public Double melhorNota(Double melhorNotaAtual){
        if (melhorNotaAtual>calculaNota()){return(melhorNotaAtual);}
        else {return(calculaNota());}
    }

    public Double piorNota(Double melhorNotaAtual){
        if (melhorNotaAtual<calculaNota()){return(melhorNotaAtual);}
        else {return(calculaNota());}
    };

}
