package com.example.attention.webview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {

    private Context context;
    private ArrayList<User> users;

    public UserAdapter(@NonNull Context context, ArrayList<User> users) {
        super(context, 0, users);
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {

            row = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        User user = users.get(position);
        if (row == null) {
            TextView textViewName = row.findViewById(R.id.textView_name);
            TextView textViewEmail = row.findViewById(R.id.textView_email);
            textViewName.setText(user.getName());
            textViewEmail.setText(user.getEmail());
        }
        return  row;
    }

}
