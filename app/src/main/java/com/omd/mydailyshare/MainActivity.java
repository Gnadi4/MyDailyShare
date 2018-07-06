package com.omd.mydailyshare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_write;
    TextView tv_daily;
    //EditText w1;
    String input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyListener myListener= new MyListener();
        MyView myView = new MyView(this);
        setContentView(R.layout.activity_main);

        button_write=(Button)findViewById(R.id.button_write);
        button_write.setOnClickListener(myListener);
        tv_daily=(TextView)findViewById(R.id.tv_daily);
        //w1=(EditText)findViewById(R.id.w1);
        WriteActivity writeActivity = new WriteActivity();

        input2 = writeActivity.input2;
    }



    class MyView extends View {
        MyView(Context context){
            super(context);

        }
    }

    class MyListener implements View.OnClickListener{

        public void onClick(View view){
            Toast.makeText(MainActivity.this, "test",Toast.LENGTH_SHORT).show();
            //input1 = w1.getText().toString();

            tv_daily.setText(input2);
            Intent intent1 = new Intent(getApplicationContext(), WriteActivity.class);
            startActivity(intent1);
        }
    }
}
