package com.example.dps_guia6.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dps_guia6.databinding.RepositoryItemBinding;
import com.example.dps_guia6.dto.Repository;

public class RepositoryViewHolder extends RecyclerView.ViewHolder {

    private RepositoryItemBinding binding;

    public RepositoryViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = RepositoryItemBinding.bind(itemView);
    }

    public void bind(Repository repository){
        binding.txtName.setText(repository.getName());
        binding.txtUrl.setText(repository.getHtml_url());
    }

}
