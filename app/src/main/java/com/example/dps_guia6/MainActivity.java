package com.example.dps_guia6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.dps_guia6.adapter.RepositoryAdapter;
import com.example.dps_guia6.databinding.ActivityMainBinding;
import com.example.dps_guia6.dto.Repository;
import com.example.dps_guia6.interfaces.APIService;
import com.example.dps_guia6.services.Servicio;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<Repository> repositories = new ArrayList<>();
    private APIService apiService;
    private RepositoryAdapter repositoryAdapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService = Servicio.service;
        repositoryAdapter = new RepositoryAdapter(repositories);
        binding.recyclerView.setAdapter(repositoryAdapter);
        binding.searchUser.setOnQueryTextListener(this);
    }

    private void searchByName(String username){
        apiService.getRepositories(username).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response != null && response.body() !=null)
                {
                    repositories.clear();
                    repositories.addAll(response.body());
                    repositoryAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this,"Failed to recover",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                if(null != t){
                    Toast.makeText(MainActivity.this,"Fallo :c",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if(!query.isEmpty()){
            searchByName(query);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }
}