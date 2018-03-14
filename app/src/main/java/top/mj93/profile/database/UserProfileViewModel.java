package top.mj93.profile.database;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.List;


public class UserProfileViewModel extends ViewModel{



    public LiveData<List<UserBean>>  getUser(Context mCtx){
        return UserDB.getInstance(mCtx).userDao().getAll();
    }



}
