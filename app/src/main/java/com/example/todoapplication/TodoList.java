package com.example.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TodoList extends AppCompatActivity {

    TextView textView;
    Button button;
    ImageView imageView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list);
        textView = (TextView)findViewById(R.id.textView);
        textView1 = (TextView)findViewById(R.id.textView1);
        imageView = (ImageView)findViewById(R.id.imageView);
        button = (Button)findViewById(R.id.button);

        Intent i = getIntent();
        Bundle b = i.getExtras();
       // Todo todo = (Todo)b.getSerializable("Todo");

        String s1 = b.getString("k1");
        String s2 = b.getString("k2");
        int icon = b.getInt("k3");

        textView.setText(s1);
        textView1.setText(s2);
        imageView.setImageResource(icon);

    }

    public void back(View v) {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2);
        finish();
    }
}
