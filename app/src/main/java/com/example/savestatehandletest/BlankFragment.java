package com.example.savestatehandletest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BlankFragment extends Fragment {
    Button button;
    EditText editText;
    TextView textView;
    private SavedStateViewModel savedStateViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button = view.findViewById(R.id.button);
        editText = view.findViewById(R.id.edit_text);
        textView = view.findViewById(R.id.text_view_activity);
        savedStateViewModel = new ViewModelProvider(this,
                new SavedStateViewModelFactory(requireActivity().getApplication(), this)).get(SavedStateViewModel.class);

        savedStateViewModel.getStringLiveData().observe(getViewLifecycleOwner(), s -> textView.setText(s));
        button.setOnClickListener(v -> savedStateViewModel.setString(editText.getText().toString()));

        super.onViewCreated(view, savedInstanceState);
    }
}