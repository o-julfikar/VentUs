package com.zulfikar.ventus.view.ui.swap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SwapViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SwapViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is swap fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}