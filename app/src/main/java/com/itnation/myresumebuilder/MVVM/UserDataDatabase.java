package com.itnation.myresumebuilder.MVVM;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {UserData.class}, version = 1)
@TypeConverters({BitmapTypeConverter.class})
public abstract class UserDataDatabase extends RoomDatabase {

    public abstract UserDataDao userDataDao();

    private static volatile UserDataDatabase INSTANCE;

    public static UserDataDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserDataDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    UserDataDatabase.class, "user_data_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
