package com.example.teamweapp;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.teamweapp.DatabaseHelper.*;

public class ViewAllActivity extends Activity {

    ListView lv_credentials;
    Button btn_viewall;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_database);
        lv_credentials = findViewById(R.id.lv_credentials);
        btn_viewall=findViewById(R.id.btn_viewall);



        btn_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper=new DatabaseHelper(ViewAllActivity.this);
               List<CredentialsModel> returnList=databaseHelper.getEveryone();
                ArrayAdapter <CredentialsModel>  credArrayAdapter= new ArrayAdapter<CredentialsModel>(ViewAllActivity.this, android.R.layout.simple_list_item_1, returnList);
                lv_credentials.setAdapter(credArrayAdapter);
            }


        });


    }
}