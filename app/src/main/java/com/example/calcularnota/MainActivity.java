package com.example.calcularnota;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.function.DoublePredicate;

public class MainActivity extends AppCompatActivity {

    private EditText nomeAluno;
    private EditText notas[] = new EditText[4];
    private TextView media;
    private Button btnCalcularNota;
    private TextView topAluno;
    private TextView melhorNota;

    private TextView piorAluno;
    private TextView piorNota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcularNota = (Button) findViewById(R.id.btnCalcularNota);
        media = (TextView) findViewById(R.id.media);
        nomeAluno = (EditText) findViewById(R.id.nomeAluno);
        notas[0] = (EditText) findViewById(R.id.nota1);
        notas[1] = (EditText) findViewById(R.id.nota3);
        notas[2] = (EditText) findViewById(R.id.nota2);
        notas[3] = (EditText) findViewById(R.id.nota4);

        topAluno = (TextView) findViewById(R.id.topAluno);
        melhorNota = (TextView) findViewById(R.id.melhorNota);

        piorAluno = (TextView) findViewById(R.id.piorAluno);
        piorNota = (TextView) findViewById(R.id.piorNota);

        btnCalcularNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double notasDouble[] = new Double[4];
                notasDouble[0] = Double.parseDouble(notas[0].getText().toString());
                notasDouble[1] = Double.parseDouble(notas[1].getText().toString());
                notasDouble[2] = Double.parseDouble(notas[2].getText().toString());
                notasDouble[3] = Double.parseDouble(notas[3].getText().toString());

                Alunos aluno = new Alunos(nomeAluno.getText().toString(), notasDouble);
                media.setText(String.valueOf(aluno.calculaNota()+"\n"+aluno.statusAluno(aluno.calculaNota())));

                try {
                    // se o resultado do calcular for maior que o que ta na tela atualize o nome
                    if(aluno.calculaNota()>Double.parseDouble(melhorNota.getText().toString())){
                        topAluno.setText(nomeAluno.getText().toString());
                    }
                    melhorNota.setText(String.valueOf(aluno.melhorNota(Double.parseDouble(melhorNota.getText().toString()))));

                }catch(Exception e){
                    melhorNota.setText(String.valueOf(aluno.melhorNota(aluno.calculaNota())));
                    topAluno.setText(nomeAluno.getText().toString());
                }
                // se o resultado do calcular for menor que o que ta na tela, atualize

                try {
                    piorNota.setText(String.valueOf(aluno.piorNota(Double.parseDouble(piorNota.getText().toString()))));
                }catch(Exception e){
                    piorNota.setText(String.valueOf(aluno.calculaNota()));
                    piorAluno.setText(nomeAluno.getText().toString());
                }





            }
        });
    }
}