package com.example.student.ss101205;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    TextView tv;
    EditText ed;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        ed = (EditText) findViewById(R.id.editText);
        sp = getSharedPreferences("mydata", MODE_PRIVATE);




    }

    public void click(View view)
    {
        if(username != null){
            username = ed.getText().toString();
        }else {
            username = sp.getString("username", "Mary");
        }
        tv.setText(username);
        //資料存放在DDMS中的data/data/package name/shared_prefs/xxx.xml
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", ed.getText().toString());
        editor.commit();
    }
}
