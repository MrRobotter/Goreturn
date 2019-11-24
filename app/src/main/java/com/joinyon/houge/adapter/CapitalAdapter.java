package com.joinyon.houge.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.joinyon.houge.R;
import com.joinyon.houge.api.ApiConstants;
import com.joinyon.houge.bean.BusinessListBean;
import com.joinyon.houge.widget.ImageViewPlus;

import java.util.List;

public class CapitalAdapter extends RecyclerView.Adapter<CapitalAdapter.ViewHolder> {
    private Context context;
    private List<BusinessListBean.ResultListBean> dataList;

    public CapitalAdapter(Context context) {
        this.context = context;
    }

    public CapitalAdapter(Context context, List<BusinessListBean.ResultListBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.capital_item, null);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final BusinessListBean.ResultListBean bean = dataList.get(position);
        holder.tvName.setText(bean.getXM());
        holder.tvNickName.setText(bean.getGZZW());
        holder.tvComName.setText(bean.getGZDW());
        String tag = bean.getGZLY();

        Glide.with(context)
                .load(ApiConstants.BASE_URL + "investment/" + bean.getTX())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.viewPlus);
        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
        if (tag == null) {

        } else {
            String[] tags = tag.split(";");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(5, 0, 10, 0);
            for (int i = 0; i < tags.length; i++) {
                if (i <= 2) {
                    TextView tv = new TextView(context);
                    tv.setPadding(3, 2, 5, 2);
                    tv.setText(tags[i]);
                    tv.setMaxEms(10);
                    tv.setTextSize(10);
                    tv.setSingleLine();
                    tv.setTextColor(context.getResources().getColor(R.color.white));
                    tv.setBackgroundResource(R.drawable.tags_bg);
                    tv.setLayoutParams(layoutParams);
                    holder.llTags.addView(tv, layoutParams);
                } else {//只显示三个标签

                }
            }
        }
    }

    private OnClickListener listener;

    public OnClickListener getListener() {
        return listener;
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public interface OnClickListener {
        void onClick(int position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llItem, llTags;
        private ImageView viewPlus;
        private TextView tvName, tvNickName, tvComName, tvConState;

        public ViewHolder(View itemView) {
            super(itemView);
            llItem = itemView.findViewById(R.id.llItem);
            llTags = itemView.findViewById(R.id.llTags);
            viewPlus = itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvName);
            tvNickName = itemView.findViewById(R.id.tvNickName);
            tvComName = itemView.findViewById(R.id.tvComName);
            tvConState = itemView.findViewById(R.id.tvConState);

        }

    }
}
