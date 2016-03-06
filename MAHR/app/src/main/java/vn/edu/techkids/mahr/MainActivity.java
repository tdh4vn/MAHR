package vn.edu.techkids.mahr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		getSupportActionBar().hide();
        this.initListener();
        this.addAnimation();
    }
    //Them listener cho 2 button chon nhan cong nguoi Viet hoac Indo
    private void initListener(){
        Button btnIndonesia = (Button) this.findViewById(R.id.btnIndonesia);
        Button btnVietnam = (Button) this.findViewById(R.id.btnVietnam);
        btnIndonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListJobsActivity.class);
                intent.putExtra(Constants.KEY_INDONESIA, Constants.KEY_INDONESIA);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
            }
        });
        btnVietnam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListJobsActivity.class);
                intent.putExtra(Constants.KEY_VIETNAM, Constants.KEY_VIETNAM);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
            }
        });
    }
    //Them animation
    private void addAnimation(){
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}
