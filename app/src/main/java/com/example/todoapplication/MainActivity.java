package com.example.todoapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    TodoAdapter adapter;
    List<Todo> todos;
    boolean flag = false;
    TextView textView1;
    TextView textView2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list_id);
        todos = new ArrayList<Todo>();
        todos.add(new Todo("1", "description 1", android.R.drawable.checkbox_on_background));
        todos.add(new Todo("2", "description 2", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("3", "description 3", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("4", "description 4", android.R.drawable.checkbox_on_background));
        todos.add(new Todo("5", "description 5", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("6", "description 6", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("7", "description 7", android.R.drawable.checkbox_on_background));
        todos.add(new Todo("8", "description 8", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("9", "description 9", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("10", "description 10", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("11", "description 11", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("12", "description 12", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("13", "description 13", android.R.drawable.checkbox_on_background));
        todos.add(new Todo("14", "description 14", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("15", "description 15", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("16", "description 16", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("17", "description 17", android.R.drawable.checkbox_off_background));
        todos.add(new Todo("18", "description 18", android.R.drawable.checkbox_off_background));

        adapter = new TodoAdapter(this, R.layout.row, todos);
        list.setAdapter(adapter);

        //addListenerOnButtonClick();

        textView1 = (TextView)findViewById(R.id.rowTitle);
        textView2 = (TextView)findViewById(R.id.rowDesc);
        imageView = (ImageView)findViewById(R.id.imageView);

        list.setItemsCanFocus(false);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
//                Toast.makeText(MainActivity.this, parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
//                Todo todo = adapter.getItem(position);
//                todo.getDrawerToggleDelegate();

                String s1 = todos.get(position).toString();
                String s2 = todos.get(position).getDescription().toString();
                int s3 = todos.get(position).getIconIndex();
               // b.putSerializable("Todo", todos);
                Intent i1 = new Intent(MainActivity.this, TodoList.class);
                i1.putExtra("k1", s1);
                i1.putExtra("k2", s2);
                i1.putExtra("k3", s3);
              //  i1.putExtras(b);
                startActivity(i1);
//                imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(todos.get(position).getIconIndex() == android.R.drawable.checkbox_off_background){
//                            todos.get(position).setIconIndex(android.R.drawable.checkbox_on_background);
//                        }
//                        else {
//                            todos.get(position).setIconIndex(android.R.drawable.checkbox_off_background);
//                        }
//                    }
//                });
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setMessage("Are you sure you want to delete this item?");
                b.setTitle("Delete Item");
                b.setCancelable(false);
                b.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        todos.remove(parent.getAdapter().getItem(position));
                        adapter.notifyDataSetChanged();
                        //Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alertDialog = b.create();
                alertDialog.show();
                return true;
            }
        });

//        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
//        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
//            @Override
//            public View makeView() {
//                ImageView imageView = new ImageView(getApplicationContext());
//               // imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
//                return imageView;
//            }
//        });
    }


//    public void doSomething (AdapterView<?> adapterView, View view, int position, long id) {
//        String s = todos.get(position).toString();
//        Intent i1 = new Intent(view.getContext(), TodoList.class);
//        i1.putExtra("li", s);
//        startActivity(i1);
//    }

    private void addListenerOnButtonClick() {

    }
}
