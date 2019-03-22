package com.filmes.omdbapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FilmesActivity extends AppCompatActivity {

    private TextView nomefilme, anofilme, generofilme, atoresfilme, diretoresfilme, sinopsefilme;
    private String nome, ano, atores, genero, diretores, sinopse, fotocapa;
    private ImageView capafilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes);

        // Atribuindo os elementos do layout pelo ID
        nomefilme = findViewById(R.id.nomeid);
        anofilme = findViewById(R.id.anoid);
        generofilme = findViewById(R.id.generoid);
        capafilme = findViewById(R.id.imageid);
        atoresfilme = findViewById(R.id.atoresid);
        diretoresfilme = findViewById(R.id.diretoresid);
        sinopsefilme = findViewById(R.id.sinopseid);


        //Recuperando dados da Tela MainActivity
        Bundle extra = getIntent().getExtras();

        fotocapa = extra.getString("FotoFilme");
        nome = extra.getString("NomeFilme");
        ano = extra.getString("AnoFilme");
        genero = extra.getString("GeneroFilme");
        atores = extra.getString("AtoresFilme");
        diretores = extra.getString("DiretoresFilme");
        sinopse = extra.getString("SinopseFilme");


        // Setando os valores recuperados na tela
        nomefilme.setText(nome);
        anofilme.setText(ano);
        atoresfilme.setText(atores);
        generofilme.setText(genero);
        diretoresfilme.setText(diretores);
        sinopsefilme.setText(sinopse);

        // Verifica se há foto ou não do filme
        if (fotocapa.equals("N/A")) {
            // Carrega imagem em PNG sem foto.
            capafilme.setImageResource(R.drawable.semfoto);
        } else {
            // Carregando foto da capa do filme na tela
            Picasso.get().load(fotocapa).into(capafilme);
        }

    }
}
