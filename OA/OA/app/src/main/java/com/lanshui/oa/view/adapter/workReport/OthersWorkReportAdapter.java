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
import com.lanshui.oa.view.model.WorkReport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class OthersWorkReportAdapter extends RecyclerView.Adapter {

    private static final String TAG = Constants.TAG + OthersWorkReportAdapter.class.getSimpleName();
    private boolean DEBUG = false;

    private List<WorkReport> data;
    private LayoutInflater inflater;

    private OnRecyclerViewListener onRecyclerViewListener;

    public OthersWorkReportAdapter(Context context , List<WorkReport> data){
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(Constants.DEBUGMODE && DEBUG){
            Log.d(TAG,"viewHolder is onCreate");
        }

        /**
         * 此处复用了“我的工作汇报列表”的布局，如果以后情况有变需要重新改写
         */

        View view = inflater.inflate(R.layout.item_my_work_report_group,null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return new WorkReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(Constants.DEBUGMODE && DEBUG){
            Log.d(TAG,"viewHolder is onBind");
        }

        WorkReportViewHolder viewHolder = (WorkReportViewHolder) holder;
        viewHolder.position = position;
        WorkReport workReport = data.get(position);
        viewHolder.imageView.setBackgroundResource(R.mipmap.message_all_message);
        viewHolder.from.setText(""+workReport.getnCreateUid());
        viewHolder.title.setText(workReport.getnTitle());
        viewHolder.date.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnRecyclerViewListener(OnRecyclerViewListener listener){
        this.onRecyclerViewListener = listener;
    }

    class WorkReportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        View rootView;
        ImageView imageView;
        TextView from;
        TextView title;
        TextView date;
        public int position;

        public WorkReportViewHolder(View itemView) {
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

    public interface OnRecyclerViewListener{
        public void onItemClick(int position);
        public boolean onItemLongPress(int position);
    }
}
