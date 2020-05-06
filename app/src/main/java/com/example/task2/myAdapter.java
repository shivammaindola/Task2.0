package com.example.task2;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    static ArrayList<Model> textlist;
    static ArrayList<EditText> edittest;
    myAdapter(ArrayList<Model> textlist, ArrayList<EditText> edittest)
    {
        this.edittest=edittest;
        myAdapter.textlist =textlist;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.edit_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.text.setHint(textlist.get(position).hint);
        textlist.get(position).setRegex(textlist.get(position).regex);
        textlist.get(position).setName(textlist.get(position).name);
    }

    @Override
    public int getItemCount() {
        return textlist.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{

        EditText text;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.edit_text);

            text.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    textlist.get(getAdapterPosition()).setEdit(text.getText().toString());
                    edittest.add(text);
                   //
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });


        }

    }

}

