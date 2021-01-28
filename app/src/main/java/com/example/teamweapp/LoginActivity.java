package com.example.teamweapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {
    Button btn_coaches, btn_players;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginchoices);
        btn_coaches=findViewById(R.id.btn_coaches);
        btn_players=findViewById(R.id.btn_players);

        btn_coaches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, CoachesActivity.class);
                startActivity(intent);
            }
        });

        btn_players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LoginActivity.this, PlayersActivity.class);
                startActivity(intent);
            }
        });
    }
}