package com.example.attention.webview2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private  EditText editTextEmail;
    private ListView listView;
    private ArrayList<User> users =new ArrayList<>();
    private  UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName =findViewById(R.id.ediText_name);
        editTextEmail=findViewById(R.id.ediText_email);
        listView=findViewById(R.id.listView);
        adapter =new UserAdapter(this,users);
        listView.setAdapter(adapter);


    }

    public void clearlist(View view) {

        AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("clearing list");
        alert.setMessage("are you sure?");

        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                users.clear();
                adapter.notifyDataSetChanged();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                users.clear();
                adapter.notifyDataSetChanged();
            }
        });
        alert.setCancelable(false);
        alert.show();
    }

    public void Submit(View view) {
        String name =editTextName.getText().toString();
        String email =editTextEmail.getText().toString();
        users.add(new User(email,name));

        adapter.notifyDataSetChanged();
    }

    public void opengoogle(View view) {

        Intent intent =new Intent( this,SecondActivity.class);
        intent.putExtra("url","https://google.com");
        startActivity(intent);
    }
}
