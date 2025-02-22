package com.example.raterta_recycler_sorted;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private List<Person> personList;

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.nameTextView.setText(person.getName());
        holder.genderTextView.setText(person.getGender());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, genderTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            genderTextView = itemView.findViewById(R.id.genderTextView);
        }
    }

    public void updateList(List<Person> newList) {
        personList = newList;
        notifyDataSetChanged();
    }
}
