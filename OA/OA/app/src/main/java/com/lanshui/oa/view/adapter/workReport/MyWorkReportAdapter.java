package com.lanshui.oa.view.adapter.workReport;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanshui.oa.R;
import com.lanshui.oa.utils.Constants;
import com.lanshui.oa.view.model.Flows;
import com.lanshui.oa.view.model.Gov;
import com.lanshui.oa.view.model.TransFlow;
import com.lanshui.oa.view.model.WorkReport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class MyWorkReportAdapter extends RecyclerView.Adapter {

    private static final String TAG = Constants.TAG + MyWorkReportAdapter.class.getSimpleName();
    private boolean DEBUG = true;

    private List<TransFlow> data;
    private LayoutInflater inflater;

    private OnRecyclerViewListener onRecyclerViewListener;

    private int sign;

    /**
     * 用于标识是否需要显示头标
     */
    private static final int NORMAL_ITEM = 0x11;
    private static final int GROUP_ITEM = 0x22;

    public MyWorkReportAdapter(Context context , List<TransFlow> data , int sign){
        this.data = data;
        inflater = LayoutInflater.from(context);
        this.sign = sign;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(Constants.DEBUGMODE && DEBUG){
            Log.d(TAG,"viewHolder is onCreate");
        }

        if(viewType == NORMAL_ITEM){
            View view = inflater.inflate(R.layout.item_my_work_report_normal,parent,false);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
            return new NormalItemViewHolder(view);
        }else{
            View view = inflater.inflate(R.layout.item_my_work_report_group,parent,false);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
            return new GroupItemViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(Constants.DEBUGMODE && DEBUG){
            Log.d(TAG,"viewHolder is onBind");
        }

        TransFlow entity = data.get(position);

        if(entity == null){
            return;
        }

        if(holder instanceof GroupItemViewHolder){
            GroupItemViewHolder viewHolder = (GroupItemViewHolder) holder;
            if(position == sign){
                viewHolder.type.setText(R.string.tv_todo_flow);
                viewHolder.from.setText(""+((Flows)entity).getCreatorId());
                viewHolder.title.setText(((Flows)entity).getFlowName());
                viewHolder.date.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            }else if(position == 0){
                viewHolder.type.setText(R.string.tv_todo_offcial);
                viewHolder.from.setText(""+((Gov)entity).getCreatorId());
                viewHolder.title.setText(((Gov)entity).getFlowName());
                viewHolder.date.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            }
        }else{
            NormalItemViewHolder viewHolder1 = (NormalItemViewHolder) holder;
            if(position > sign){
                viewHolder1.from.setText(""+((Flows)entity).getCreatorId());
                viewHolder1.title.setText(((Flows)entity).getFlowName());
                viewHolder1.date.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            }else if(position < sign){
                viewHolder1.from.setText(""+((Gov)entity).getCreatorId());
                viewHolder1.title.setText(((Gov)entity).getFlowName());
                viewHolder1.date.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            }
        }

    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return GROUP_ITEM;
        }

        if(position == sign){
            return GROUP_ITEM;
        }
        return NORMAL_ITEM;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnRecyclerViewListener(OnRecyclerViewListener listener){
        this.onRecyclerViewListener = listener;
    }

    /**
     *
     */
    class NormalItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        View rootView;
        ImageView imageView;
        TextView from;
        TextView title;
        TextView date;
        public int position;

        public NormalItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_item_work_report_detail);
            from = (TextView) itemView.findViewById(R.id.tv_item_work_report_from);
            title = (TextView) itemView.findViewById(R.id.tv_item_work_report_content);
            date = (TextView) itemView.findViewById(R.id.tv_item_work_report_date);
            rootView = itemView.findViewById(R.id.item_my_work_report_view);
            if(rootView == null){
                Log.d(TAG,"rootview is null");
            }else {
                rootView.setOnClickListener(this);
                rootView.setOnLongClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            if(onRecyclerViewListener != null){
                Log.d(TAG,"item onClicked");
                onRecyclerViewListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(onRecyclerViewListener != null){
                return onRecyclerViewListener.onItemLongPress(position);
            }
            return false;
        }
    }

    class GroupItemViewHolder extends NormalItemViewHolder{

        TextView type;

        public GroupItemViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.tv_work_report_date);
        }
    }

    public interface OnRecyclerViewListener{
        public void onItemClick(int position);
        public boolean onItemLongPress(int position);
    }
}
