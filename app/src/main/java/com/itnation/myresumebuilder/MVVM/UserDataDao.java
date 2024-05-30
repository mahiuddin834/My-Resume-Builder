package com.itnation.myresumebuilder.MVVM;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDataDao {
    @Insert
    void insert(UserData userData);

    @Update
    void update(UserData userData);

    @Query("SELECT * FROM user_data ORDER BY id DESC")
    LiveData<List<UserData>> getAllUserData();



}
