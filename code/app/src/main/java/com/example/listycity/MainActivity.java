package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ListView cityList;
    EditText cityInput;
    Button addCityBtn;
    Button deleteCityBtn;

    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;


    int index = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cityList = findViewById(R.id.city_list);
        cityInput = findViewById(R.id.city_input);
        addCityBtn = findViewById(R.id.add_city_btn);
        deleteCityBtn = findViewById(R.id.delete_city_btn);

        String []cities = {"Berlin", "Vienna", "Tokyo", "Beijing", "Osaka"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,dataList);
        cityList.setAdapter(cityAdapter);

        //Add a city to the list
        addCityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = cityInput.getText().toString();

                if (!city.isEmpty()) {
                    dataList.add(city);
                    cityAdapter.notifyDataSetChanged();
                    cityInput.setText("");
                }
            }
        });




    }






}