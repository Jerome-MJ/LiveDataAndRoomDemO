package top.mj93.profile.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class UserBean {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public UserBean(String name) {
        this.name = name;
    }
}
