package huangshun.it.com.androiddesignpattern.play.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.play.bean.PageBean;

/**
 * Created by hs on 2017/8/4.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {

    private Context mContext;
    private List<PageBean.DatasBean> mDatas;

    public RecommendAdapter(Context context, List<PageBean.DatasBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View inflate = View.inflate(mContext, R.layout.template_recomend_app, null);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.template_recomend_app, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PageBean.DatasBean datasBean = mDatas.get(position);
        //设置数据
        holder.mTextTitle.setText(datasBean.getDisplayName());
        holder.mTextSize.setText(datasBean.getApkSize() / 1024 / 1024 + "MB");
        String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";
        Picasso.with(mContext).load(baseImgUrl + datasBean.getIcon()).into(holder.mImgIcon);

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon)
        ImageView mImgIcon;
        @BindView(R.id.text_title)
        TextView mTextTitle;
        @BindView(R.id.text_size)
        TextView mTextSize;
        @BindView(R.id.btn_dl)
        Button mBtnDl;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
