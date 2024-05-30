package com.itnation.myresumebuilder.MVVM;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserDataViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private final LiveData<List<UserData>> allUserData;

    public UserDataViewModel(Application application) {
        super(application);
        repository = new UserRepository(application);
        allUserData = repository.getAllUserData();
    }

    public LiveData<List<UserData>> getAllUserData() {
        return allUserData;
    }

    public void insert(UserData userData) {
        repository.insert(userData);
    }


    public void updateUserData(UserData userData) {
        repository.updateUserData(userData);
    }
}
