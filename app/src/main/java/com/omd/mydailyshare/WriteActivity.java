package com.omd.mydailyshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WriteActivity extends AppCompatActivity {

    Button button_back;
    EditText t_write;
    String input2;
    Button button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MD2.db", null, 1);


        button_back=(Button)findViewById(R.id.button_back);
        t_write = (EditText)findViewById(R.id.t_write);
        input2 = t_write.getText().toString();


        /*button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String date = etDate.getText().toString();

                //int price = Integer.parseInt(etPrice.getText().toString());


                //result.setText(dbHelper.getResult());
            }
        });*/





        Button.OnClickListener multiClick = new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                String data = t_write.getText().toString();
                switch (view.getId()) {
                    case R.id.button_back:
                        finish();
                        break;
                    case R.id.button_save:
                        dbHelper.insert(null,null ,data);
                        break;
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

        findViewById(R.id.button_back).setOnClickListener(multiClick);
        findViewById(R.id.button_save).setOnClickListener(multiClick);
    }

}
