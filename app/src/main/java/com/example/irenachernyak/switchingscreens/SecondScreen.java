package com.example.irenachernyak.switchingscreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by irenachernyak on 8/6/15.
 */
public class SecondScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("CallingActivity");

        TextView activitynameTV = (TextView)findViewById(R.id.calling_activity_info_text_view);
        activitynameTV.append("  " + previousActivity);
    }

    public void onSendUserName(View view) {

        EditText userNameET = (EditText)findViewById(R.id.user_name_edittext);
        String username = String.valueOf(userNameET.getText());

        //sending user name back to MainActivity, again - via Intent
        Intent goBackIntent = new Intent();
        goBackIntent.putExtra("UserName", username);
        setResult( RESULT_OK,goBackIntent);
        finish(); // since this screen is done!

    }
}
