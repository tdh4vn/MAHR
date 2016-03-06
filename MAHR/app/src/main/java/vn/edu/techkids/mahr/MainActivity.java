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
    }

    private void initListener(){
        Button btnIndonesia = (Button) this.findViewById(R.id.btnIndonesia);
        Button btnVietnam = (Button) this.findViewById(R.id.btnVietnam);
        btnIndonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListJobsActivity.class);
                intent.putExtra(Constants.KEY_INDONESIA,Constants.KEY_INDONESIA);
            }
        });
        btnVietnam.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListJobsActivity.class);
                intent.putExtra(Constants.KEY_VIETNAM, Constants.KEY_VIETNAM);
            }
        });
    }
}
