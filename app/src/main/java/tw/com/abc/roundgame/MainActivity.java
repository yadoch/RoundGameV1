package tw.com.abc.roundgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTvRound,mTvResource1,mTvTotUnit,mTvTotLand,mTvEp;
    private int intRound, intResource1, intTotUnit, intTotLand,intEp;
    private int newRoundResource1,useRound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public  void addLand(View v){
        if(intTotUnit <= 0){
            Toast.makeText(this, "No Unit!! You Can't add land !", Toast.LENGTH_SHORT).show();
        }else{

            if(intEp > 0) {

                int loseUnit = (int) (Math.random()*5);
                intTotUnit -= loseUnit;
                if(intTotUnit < 0){
                    intTotUnit = 0;
                    Toast.makeText(this, "You lose all unit!!", Toast.LENGTH_SHORT).show();
                }else {
                    intTotLand += 1;
                    Toast.makeText(this, "You lose "+loseUnit+" unit!!Land add:1", Toast.LENGTH_SHORT).show();
                }
                intEp -= 1;
            }else {
                Toast.makeText(this,"No Executive Power,Please End Round!!",Toast.LENGTH_SHORT).show();
            }

            //畫面更新
            renewDisplay();

        }
    }

    public  void addUnit(View v){
        //每按一下新增單位
        if(intEp > 0){
            intTotUnit += 1;
            intEp -=1;
            //畫面更新
            renewDisplay();
            Toast.makeText(this,"The Unit add:1",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"No Executive Power,Please End Round!!",Toast.LENGTH_SHORT).show();
        }


    }

    public void endRound(View v){
        if(intTotLand < 6) {
            //每回合新增資源計算
            countResource();
            intRound += 1;
            intEp = 2;
            //畫面更新
            renewDisplay();
            Toast.makeText(this, "The " + intRound + " Round,Food add:" + newRoundResource1 + ";Unit use :" + useRound, Toast.LENGTH_SHORT).show();
        }else {Toast.makeText(this, "You Win!! Game Over!!", Toast.LENGTH_SHORT).show();}
    }
    //每回合新增資源計算
    private void countResource() {

        useRound= intTotUnit *1;

        newRoundResource1 = intTotLand *3+(int)(Math.random()*5);
        intResource1 += newRoundResource1;
        intResource1 -= useRound;
    }

    private void init() {
        intRound =0;
        intEp=2;
        intResource1 =0;
        intTotUnit =0;
        intTotLand =1;

        mTvRound= (TextView) findViewById(R.id.tv_round);
        mTvEp=(TextView)findViewById(R.id.tv_ep);
        mTvResource1= (TextView) findViewById(R.id.tv_resource1);
        mTvTotUnit= (TextView) findViewById(R.id.tv_unit1);
        mTvTotLand= (TextView) findViewById(R.id.tv_land);
        renewDisplay();
    }
    //畫面更新
    private void renewDisplay() {
        mTvRound.setText(String.valueOf(intRound));
        mTvEp.setText(String.valueOf(intEp));
        mTvResource1.setText(String.valueOf(intResource1));
        mTvTotLand.setText(String.valueOf(intTotLand));
        mTvTotUnit.setText(String.valueOf(intTotUnit));
    }

}
