package huangshun.it.com.androiddesignpattern.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2018/1/9.
 */

public class DivideAdapter extends RecyclerView.Adapter<DivideAdapter.ViewHolder> {
    private static final String TAG = "DivideAdapter";
    private List<String> data = new ArrayList<>();


    public DivideAdapter(List<String> data) {
        this.data = data;
        Log.i(TAG, "size:" + data.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View inflate = View.inflate(parent.getContext(), R.layout.item_divide, parent);
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_divide, parent, false);
//        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) inflate.getLayoutParams();
//        layoutParams.topMargin = 100;
//        inflate.setLayoutParams(layoutParams);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvData.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_data)
        TextView mTvData;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
