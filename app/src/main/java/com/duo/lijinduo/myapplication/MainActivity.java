package com.duo.lijinduo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.duo.lijinduo.myapplication.db.AdressOperation;
import com.duo.lijinduo.myapplication.db.UserOperation;

import java.lang.reflect.Field;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.button10)
    Button button100;
    @Bind(R.id.button11)
    Button button111;
    @Bind(R.id.button12)
    Button button12;
    @Bind(R.id.button13)
    Button button13;
    @Bind(R.id.button14)
    Button button14;
    @Bind(R.id.button15)
    Button button15;
    @Bind(R.id.button16)
    Button button16;
    @Bind(R.id.button17)
    Button button17;
    @Bind(R.id.button18)
    Button button18;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;

    private UserOperation userOperation = UserOperation.getUserDao();

    private AdressOperation adressOperation = AdressOperation.getUserDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button, R.id.button2,R.id.button3,R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button10:
                userOperation.query();
                break;
            case R.id.button11:
                userOperation.queryAgeFlashback();
                break;
            case R.id.button12:
                userOperation.upDateAk47("ak47", "ak47无敌版");
                break;
            case R.id.button13:
                userOperation.clearWangZhaoJun();
                break;
            case R.id.button14:
                userOperation.insert();
                break;
            case R.id.button15:
                userOperation.queryById();
                break;
            case R.id.button16:
                userOperation.clearZhuGeLiangList("诸葛亮");
                break;
            case R.id.button17:
                adressOperation.insertAddress();
                break;
            case R.id.button18:
                adressOperation.queryAddress();
                break;
            case R.id.button:
                userOperation.clear();
                break;
            case R.id.button2:
                adressOperation.clear();
                break;
            case R.id.button3:
                qRawName();
                break;
        }
    }

    private void qRawName() {
        Field[] fields = R.raw.class.getDeclaredFields();
        String rawName;
        for (int i = 0; i < fields.length; i++) {
            try {
                rawName = fields[i].getName();
                Log.d("读取的数据", "-----------rawName="+rawName+"----------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
