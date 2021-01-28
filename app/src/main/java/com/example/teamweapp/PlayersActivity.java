package com.example.teamweapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class PlayersActivity extends Activity {

    Button btn_viewall,btn_signin;
    EditText et_username,et_password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_login);

        btn_signin = findViewById(R.id.btn_signin);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_viewall=findViewById(R.id.btn_viewall);


        btn_signin.setOnClickListener(new View.OnClickListener() {

                                          public void onClick(View v) {

                                              CredentialsModel credentialsModel;
                                              try {
                                                  credentialsModel = new CredentialsModel(1,et_username.getText().toString(),
                                                          et_password.getText().toString());
                                                  Toast.makeText(PlayersActivity.this, credentialsModel.toString(), Toast.LENGTH_SHORT).show();

                                              } catch (Exception e) {
                                                  Toast.makeText(PlayersActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                                  credentialsModel = new CredentialsModel(-1, "error", "error");
                                              }
                                              DatabaseHelper databaseHelper = new DatabaseHelper(PlayersActivity.this);
                                              boolean success;
                                              success = databaseHelper.addOne(credentialsModel);
                                              Toast.makeText(PlayersActivity.this,
                                                      "Success" + success,
                                                      LENGTH_LONG).show();
                                          }

                                      }
        );

        btn_viewall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(PlayersActivity.this, ViewAllActivity.class);
        startActivity(intent);
    }
});
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlayersActivity.this, PlayerHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}