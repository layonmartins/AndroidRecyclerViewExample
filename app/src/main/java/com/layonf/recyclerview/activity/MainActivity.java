package com.layonf.recyclerview.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.layonf.recyclerview.R;
import com.layonf.recyclerview.activity.adapter.Adapter;
import com.layonf.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmes = new ArrayList<Filme>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Create Lista filmes
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter(filmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); //to optimize
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //event click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        this,
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = filmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item clicked " + filme.getFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = filmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item long clicked " + filme.getFilme(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        })
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha 1", "Ficção", "2010");
        this.filmes.add(filme);

        filme = new Filme("Homem Aranha 2", "Ficção", "2012");
        this.filmes.add(filme);

        filme = new Filme("Homem Aranha 3", "Ficção", "2014");
        this.filmes.add(filme);

        filme = new Filme("Homem Aranha 4", "Ficção", "2016");
        this.filmes.add(filme);

        filme = new Filme("Mulher Maravilha 1", "Fantasia", "2015");
        this.filmes.add(filme);

        filme = new Filme("Mulher Maravilha 2", "Fantasia", "2017");
        this.filmes.add(filme);

        filme = new Filme("Mulher Maravilha 3", "Fantasia", "2021");
        this.filmes.add(filme);

        filme = new Filme("Liga da Justiça 1", "Ficção", "2018");
        this.filmes.add(filme);

        filme = new Filme("Liga da Justiça 2", "Ficção", "2019");
        this.filmes.add(filme);

        filme = new Filme("Liga da Justiça 3", "Ficção", "2020");
        this.filmes.add(filme);

        filme = new Filme("Captão América", "Aventura", "2013");
        this.filmes.add(filme);

        filme = new Filme("Captão América 2", "Aventura", "2017");
        this.filmes.add(filme);

        filme = new Filme("Captão América 3", "Aventura", "2019");
        this.filmes.add(filme);

        filme = new Filme("It: A Coisa", "Suspense", "2018");
        this.filmes.add(filme);

        filme = new Filme("It: A Coisa 2", "Suspense", "2022");
        this.filmes.add(filme);

        filme = new Filme("It: A Coisa 3", "Suspense", "2023");
        this.filmes.add(filme);

        filme = new Filme("A volta dos que não foram", "Suspense", "2022");
        this.filmes.add(filme);

        filme = new Filme("A volta dos que não foram 2", "Suspense", "2022");
        this.filmes.add(filme);

        filme = new Filme("Varredores do deserto", "Suspense", "2022");
        this.filmes.add(filme);

        filme = new Filme("Varredores do deserto 2", "Suspense", "2022");
        this.filmes.add(filme);
    }

}