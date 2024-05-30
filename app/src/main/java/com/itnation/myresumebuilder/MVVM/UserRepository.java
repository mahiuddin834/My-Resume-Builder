package com.itnation.myresumebuilder.MVVM;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private final UserDataDao userDataDao;
    private final LiveData<List<UserData>> allUserData;
    private final ExecutorService executorService;

    public UserRepository(Application application) {
        UserDataDatabase db = UserDataDatabase.getDatabase(application);
        userDataDao = db.userDataDao();
        allUserData = userDataDao.getAllUserData();
        executorService = Executors.newFixedThreadPool(2);
    }

    public LiveData<List<UserData>> getAllUserData() {
        return allUserData;
    }

    public void insert(UserData userData) {
        executorService.execute(() -> userDataDao.insert(userData));
    }



    public void updateUserData(UserData userData) {
        new UpdateUserDataAsyncTask(userDataDao).execute(userData);
    }

    private static class UpdateUserDataAsyncTask extends AsyncTask<UserData, Void, Void> {
        private UserDataDao userDataDao;

        UpdateUserDataAsyncTask(UserDataDao dao) {
            userDataDao = dao;
        }

        @Override
        protected Void doInBackground(final UserData... params) {
            userDataDao.update(params[0]);
            return null;
        }
    }


}
