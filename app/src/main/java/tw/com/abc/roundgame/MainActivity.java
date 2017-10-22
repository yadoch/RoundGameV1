package tw.com.abc.roundgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTvRound,mTvResource1,mTvTotUnit,mTvTotLand;
    private int mRound,mResource1,mTotUnit,mTotLand;
    private int newRoundResource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void endRound(View v){

        //每回合新增資源計算
        countResource();
        //畫面更新
        renewDisplay();
        Toast.makeText(this,"The X Round,Food add:"+newRoundResource,Toast.LENGTH_SHORT).show();
    }
    //每回合新增資源計算
    private void countResource() {

        newRoundResource = mTotLand*3+(int)(Math.random()*10);
        mResource1 += newRoundResource;
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
