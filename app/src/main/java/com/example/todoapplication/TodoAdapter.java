package com.example.todoapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<Todo> {
    Context cont;
    int res = R.layout.row;
    List<Todo> items;


    public TodoAdapter(@NonNull Context context, int resource, @NonNull List<Todo> todos) {
        super(context, resource, todos);
        cont = context;
        res = resource;
        items = todos;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        Holder h = null;
        LayoutInflater lif = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = lif.inflate(res, parent, false);
        TextView tv = row.findViewById(R.id.rowTitle);
        tv.setText(items.get(position).getName());
        TextView des = row.findViewById(R.id.rowDesc);
        des.setText(items.get(position).getDescription());
        final ImageView img = row.findViewById(R.id.imageView);
        img.setImageResource(items.get(position).getIconIndex());
        img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(items.get(position).getIconIndex() == android.R.drawable.checkbox_off_background){
                            img.setImageResource(android.R.drawable.checkbox_on_background);
                            items.get(position).setIconIndex(android.R.drawable.checkbox_on_background);
                        }
                        else {
                            img.setImageResource(android.R.drawable.checkbox_off_background);
                            items.get(position).setIconIndex(android.R.drawable.checkbox_off_background);
                        }
                    }
                });

        return row;
    }
}

class Holder{
    TextView textView1;
    TextView textView2;
    ImageView imageView;

}
