package com.example.thevolley.the_room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private NoteDao mUserDao;
    private LiveData<List<Note>> mAllUser;

    UserRepository(Application application) {
        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mAllUser = mUserDao.getAlphabetizedUsers();
    }

    LiveData<List<Note>> getAllWords() {
        return mAllUser;
    }
  void insert(Note user) {
        NoteRoomDatabase.databaseWriteExecutor.execute(() -> {
            mUserDao.insert(user);
        });
    }
}
