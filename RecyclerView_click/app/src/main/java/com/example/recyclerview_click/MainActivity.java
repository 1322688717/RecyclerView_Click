package com.example.recyclerview_click;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_oen;
    private List<Msg> date = new ArrayList<>();
    private String date1,date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_oen = findViewById(R.id.rv_one);
        //设置成线下布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_oen.setLayoutManager(linearLayoutManager);
        //设置适配器
        A_apater apater = new A_apater(date,this);
        rv_oen.setAdapter(apater);
        GatDate();

        apater.setRecyclerItemClickListener(new A_apater.OnRecycleritemclicklistener() {
            @Override
            public void onrcycyleritclick(int position) {
                Intent intent = new Intent(MainActivity.this,IntentActivity.class);
                startActivity(intent);
                Log.e("TAG","点击了第"+(position+1)+"个");
            }
        });
    }

    private void GatDate() {
        for (int i = 0;i < 30; i++){
            Msg msg = new Msg();
            msg.setName("名字"+i);
            msg.setAge("年纪"+i);
            date.add(msg);
        }
    }
}