package com.filmes.omdbapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText campofilme;
    private Button btnpesquisar;
    private String nome, ano, atores, genero, diretores, sinopse, fotocapa, filmedigitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Atribuindo os elementos do layout pelo ID
        campofilme = findViewById(R.id.filmeid);
        btnpesquisar = findViewById(R.id.botaoid);


        // Ação de clique no botão pesquisar
        btnpesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Variável para receber o nome do filme digitado
               filmedigitado = campofilme.getText().toString();

               // Verifique se a variável esta vazia ou preenchida
                if (filmedigitado.isEmpty()) {

                    campofilme.setError("Campo Vazio!");
                } else {

                    //URL da OmdbAPI
                    String url = "http://www.omdbapi.com/?t="+filmedigitado+"&plot=full&apikey=a45a2a24";

                    // Instanciando o RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue( MainActivity.this);

                    // Solicita uma resposta de string do URL da OmdbAPI.
                    StringRequest request = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    try {
                                        // Resposta da OmdbAPI será convertida para formato JSON.
                                        JSONObject filmes = new JSONObject(response);

                                        // Recebe a resposta se a pesquisa foi true ou false do OmdbAPI.
                                        String result = filmes.getString("Response");


                                        // Verifica se a resposta foi válida "True" caso localizou o Filme.
                                        if (result.equals("True")) {

                                            // Recuperando os dados e atribuindo em variáveis
                                                nome = filmes.getString("Title");
                                                ano = filmes.getString("Year");
                                                atores = filmes.getString("Writer");
                                                genero = filmes.getString("Genre");
                                                diretores = filmes.getString("Director");
                                                sinopse = filmes.getString("Plot");
                                                fotocapa = filmes.getString("Poster");


                                            // Intent para a manipulação de dados e transação de tela
                                            Intent intent = new Intent(MainActivity.this, FilmesActivity.class);

                                            // Filme escolhido será passado para a classe FilmesActivity
                                            intent.putExtra("FotoFilme", fotocapa );
                                            intent.putExtra("NomeFilme", nome );
                                            intent.putExtra("AnoFilme", ano );
                                            intent.putExtra("AtoresFilme", atores );
                                            intent.putExtra("GeneroFilme", genero );
                                            intent.putExtra("DiretoresFilme", diretores );
                                            intent.putExtra("SinopseFilme", sinopse );

                                            // Vai para a tela de Filmes
                                            startActivity(intent);

                                        } else {
                                            Toast.makeText(MainActivity.this, "Filme não encontrado!", Toast.LENGTH_SHORT).show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        Log.i("erro_volley", error.getMessage());
                        }
                    }

                    );
                    queue.add(request);

                }


            }
        });




    }
}
