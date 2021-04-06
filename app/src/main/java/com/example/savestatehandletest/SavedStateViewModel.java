package com.example.savestatehandletest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;


public class SavedStateViewModel extends ViewModel {
    private final SavedStateHandle savedStateHandle;
    private final static String KEY = "key";
    private final LiveData<String> stringLiveData;

    public SavedStateViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
        stringLiveData = savedStateHandle.getLiveData(KEY);
    }

    public void setString(String string) {
        savedStateHandle.set(KEY, string);
    }

    public LiveData<String> getStringLiveData() {
        return stringLiveData;
    }


}
