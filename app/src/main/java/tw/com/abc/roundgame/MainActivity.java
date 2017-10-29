package tw.com.abc.roundgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTvRound,mTvResource1,mTvTotUnit,mTvTotLand;
    private int mRound,mResource1,mTotUnit,mTotLand;
    private int newRoundResource1,useRound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public  void addLand(View v){
        mTotLand +=1;
        //畫面更新
        renewDisplay();
        Toast.makeText(this,"Land add:1",Toast.LENGTH_SHORT).show();
    }

    public  void addUnit(View v){
        //每按一下新增單位
        mTotUnit += 1;
        //畫面更新
        renewDisplay();
        Toast.makeText(this,"The Unit add:1",Toast.LENGTH_SHORT).show();

    }

    public void endRound(View v){

        //每回合新增資源計算
        countResource();
        mRound +=1;
        //畫面更新
        renewDisplay();
        Toast.makeText(this,"The "+ mRound  +" Round,Food add:"+ newRoundResource1+";Unit use :"+useRound ,Toast.LENGTH_SHORT).show();
    }
    //每回合新增資源計算
    private void countResource() {

        useRound=mTotUnit*1;

        newRoundResource1 = mTotLand*3+(int)(Math.random()*5);
        mResource1 += newRoundResource1;
        mResource1 -= useRound;
    }

    private void init() {
        mRound =0;
        mResource1=0;
        mTotUnit=0;
        mTotLand=1;

        mTvRound= (TextView) findViewById(R.id.tv_round);
        mTvResource1= (TextView) findViewById(R.id.tv_resource1);
        mTvTotUnit= (TextView) findViewById(R.id.tv_unit1);
        mTvTotLand= (TextView) findViewById(R.id.tv_land);
        renewDisplay();
    }
    //畫面更新
    private void renewDisplay() {
        mTvRound.setText(String.valueOf(mRound));
        mTvResource1.setText(String.valueOf(mResource1));
        mTvTotLand.setText(String.valueOf(mTotLand));
        mTvTotUnit.setText(String.valueOf(mTotUnit));
    }


}
