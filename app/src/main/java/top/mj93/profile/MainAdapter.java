package top.mj93.profile;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import top.mj93.profile.database.UserBean;

public class MainAdapter extends BaseQuickAdapter<UserBean,BaseViewHolder>{
    public MainAdapter(@Nullable List<UserBean> data) {
        super(R.layout.item_user,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserBean item) {
        helper.setText(R.id.item_user_name,helper.getAdapterPosition()+":"+item.name);
    }
}
