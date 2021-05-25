package com.example.recyclerview_click;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class A_apater extends RecyclerView.Adapter<A_apater.MyViewHold>{

    private List<Msg> msg;
    private Context mcontext;


    public A_apater(List<Msg> msg, Context mcontext) {
        this.msg = msg;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        return new MyViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHold holder, int position) {
        holder.tv_oen.setText(msg.get(position).getName());
        holder.tv_two.setText(msg.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return msg.size();
    }

    public class MyViewHold extends RecyclerView.ViewHolder{
        private TextView tv_oen,tv_two;
        public MyViewHold(@NonNull View itemView) {
            super(itemView);
            tv_oen = itemView.findViewById(R.id.tv_one);
            tv_two = itemView.findViewById(R.id.tv_two);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monRecycleritemclicklistener.onrcycyleritclick(getAdapterPosition());
                }
            });
        }
    }

    /**
     * 设置item点击监听
     */
    private OnRecycleritemclicklistener monRecycleritemclicklistener;
    public void setRecyclerItemClickListener(OnRecycleritemclicklistener listenenr){
        monRecycleritemclicklistener = listenenr;
    }
    public interface OnRecycleritemclicklistener{
         void onrcycyleritclick(int position);
    }
}