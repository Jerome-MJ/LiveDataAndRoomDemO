package top.mj93.profile.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {UserBean.class},version = 1)
public abstract class UserDB extends RoomDatabase{

    public abstract UserDao userDao();
    private static UserDB INSTANCE;
    private static final Object sLock = new Object();
    public static UserDB getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        UserDB.class, "newsbean")
                        .build();
            }
            return INSTANCE;
        }
    }

}
