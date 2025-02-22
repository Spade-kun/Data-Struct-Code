package com.example.raterta_recycler_sorted;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    private List<Person> personList;
    private List<Person> originalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Button sortButton = findViewById(R.id.sortButton);
        Button maleButton = findViewById(R.id.maleButton);
        Button femaleButton = findViewById(R.id.femaleButton);
        Button resetButton = findViewById(R.id.resetButton);

        personList = Arrays.asList(
                new Person("John", "Male"),
                new Person("Alice", "Female"),
                new Person("Michael", "Male"),
                new Person("Sophia", "Female"),
                new Person("David", "Male"),
                new Person("Emma", "Female"),
                new Person("James", "Male"),
                new Person("Olivia", "Female"),
                new Person("Robert", "Male"),
                new Person("Isabella", "Female")
        );

        originalList = new ArrayList<>(personList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonAdapter(personList);
        recyclerView.setAdapter(adapter);

        sortButton.setOnClickListener(v ->{
            List<Person> sortedList = new ArrayList<>(personList);
            Collections.sort(sortedList, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
            adapter.updateList(sortedList);
        });

        maleButton.setOnClickListener(v -> {
            List<Person> filteredList = personList.stream()
                    .filter(p -> p.getGender().equals("Male"))
                    .collect(Collectors.toList());
            adapter.updateList(filteredList);
        });

        femaleButton.setOnClickListener(v -> {
            List<Person> filteredList = personList.stream()
                    .filter(p -> p.getGender().equals("Female"))
                    .collect(Collectors.toList());
            adapter.updateList(filteredList);
        });

        resetButton.setOnClickListener( v -> adapter.updateList(originalList));

    }
}