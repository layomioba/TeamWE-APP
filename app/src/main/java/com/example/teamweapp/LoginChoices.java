package com.example.teamweapp;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONObject;

public class LoginChoices extends ListActivity {
Button btn_players, btn_coaches;
    static final String [] LOGIN_CHOICES=new String[]{"PLAYERS", "COACHES"};

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,LOGIN_CHOICES));
    getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    getListView().setTextFilterEnabled(true);
    getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            switch(arg2){
                case 0:
                    btn_players.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(LoginChoices.this, PlayersActivity.class);
                            startActivity(myIntent);
                            String response="nice";
                            Log.d("HELLO", response);
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }  });
                    break;
                case 1:
                    btn_coaches.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(LoginChoices.this,   CoachesActivity.class);
                            startActivity(myIntent);
                        }
                    });
                    break;
                default:break;
            }

        }
    });
    }


}
