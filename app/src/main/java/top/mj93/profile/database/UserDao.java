package top.mj93.profile.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    LiveData<List<UserBean>> getAll();


    @Insert
    void insert(UserBean bean);

    @Delete
    void delete(UserBean bean);
}
