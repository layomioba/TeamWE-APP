package com.example.teamweapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  Button btn_login, btn_register, btn_players, btn_coaches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        btn_login = findViewById(R.id.btn_logins);
        btn_register = findViewById(R.id.btn_registers);

        btn_login.setOnClickListener(new OnClickListener() {

                                         public void onClick(View view) {
                                             Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                             startActivity(intent);
                                         }
                                     }
        );
        btn_register.setOnClickListener(new OnClickListener() {

                                            public void onClick(View view) {
                                                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                                                startActivity(intent);
                                            }
                                        }
        );
    }



}
