package com.omd.mydailyshare;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
    String i;
    Button button_show;
    Cursor cursor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //MyListener myListener= new MyListener();
        //MyView myView = new MyView(this);
        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MD2.db", null, 1);

        button_write=(Button)findViewById(R.id.button_write);
        //button_write.setOnClickListener(myListener);
        tv_daily=(TextView)findViewById(R.id.tv_daily);
        //w1=(EditText)findViewById(R.id.w1);
        WriteActivity writeActivity = new WriteActivity();

        input2 = writeActivity.input2;

        final Button.OnClickListener multiClick = new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                //String data = t_write.getText().toString();
                switch (view.getId()) {
                    case R.id.button_write:
                        Intent intent1 = new Intent(getApplicationContext(), WriteActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button_show:
                        if(dbHelper.getResult()!=null) {
                            tv_daily.setText(dbHelper.getResult());
                            break;
                        }
                        break;
                    case R.id.button_delete:
                        dbHelper.delete();


                }
            }


            /*public String getText(){

                return input2;
            }*/


            /*@Override
            public void onClick(View view){
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }*/

        };

        findViewById(R.id.button_show).setOnClickListener(multiClick);
        findViewById(R.id.button_write).setOnClickListener(multiClick);

    }



    /*class MyView extends View {
        MyView(Context context){
            super(context);


        }
    }*/


    //i=cursor.getString(3);



    /*class MyListener implements View.OnClickListener{



        public void onClick(View view){
            Toast.makeText(MainActivity.this, "test",Toast.LENGTH_SHORT).show();
            //input1 = w1.getText().toString();

            //tv_daily.setText(dbHelper.getResult());

        }
    }*/
}
