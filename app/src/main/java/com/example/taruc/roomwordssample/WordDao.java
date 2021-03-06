package com.example.taruc.roomwordssample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Query;

import java.util.List;

public interface WordDao {

    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();





}
