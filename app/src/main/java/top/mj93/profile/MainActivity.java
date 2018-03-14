package top.mj93.profile;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import top.mj93.profile.database.UserBean;
import top.mj93.profile.database.UserDB;
import top.mj93.profile.database.UserProfileViewModel;

public class MainActivity extends AppCompatActivity {

    private Button mAddUserButton;
    private RecyclerView mListUserRecyclerView;
    private UserProfileViewModel viewModel;
    private MainAdapter mainAdapter;
    private List<UserBean> mDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddUserButton = (Button) findViewById(R.id.btn_add_user);
        mListUserRecyclerView = (RecyclerView) findViewById(R.id.rv_list_user);
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        mDatas = new ArrayList<>();
        mainAdapter = new MainAdapter(mDatas);
        viewModel.getUser(this).observe(this, new Observer<List<UserBean>>() {
            @Override
            public void onChanged(@Nullable List<UserBean> userBeans) {
                //每次插入后自动执行此回调返回所有数据源，
                mDatas.clear();
                mDatas.addAll(userBeans);
                mainAdapter.notifyDataSetChanged();
            }
        });
        mListUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListUserRecyclerView.setAdapter(mainAdapter);


    }


    /**
     * 添加用户
     *
     * @param v
     */
    public void addUser(View v) {
        final int size = mDatas.size();
        //Room的插入操作仅限子线程，所以粗糙的写了一下
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserDB.getInstance(MainActivity.this).userDao().insert(new UserBean("张三:"+size));
            }
        }).start();

    }

    /**
     * 删除用户
     *
     * @param v
     */
    public void delUser(View v) {

    }
}
