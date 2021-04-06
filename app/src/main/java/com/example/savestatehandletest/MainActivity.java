package com.example.savestatehandletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    TextView textView;
    SavedStateViewModel savedStateViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_activity, new BlankFragment()).commit();
        }
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view_activity);

        savedStateViewModel = new ViewModelProvider(this,
                new SavedStateViewModelFactory(getApplication(), this)).get(SavedStateViewModel.class);
        savedStateViewModel.getStringLiveData().observe(this, s -> textView.setText(s));


    }
}