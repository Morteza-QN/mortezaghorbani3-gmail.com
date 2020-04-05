package com.example.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Button         doneBtn    = findViewById(R.id.btn_editProfile_done);
        final EditText fullNameEt = findViewById(R.id.et_editProfile);
        String         s          = getIntent().getStringExtra(MainActivity.EXTRA_KEY_FULLNAME);// get string on mainActivity
        fullNameEt.setText(s);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str    = fullNameEt.getText().toString();
                Intent intent = new Intent();//sent values to mainActivity
                intent.putExtra(MainActivity.EXTRA_KEY_FULLNAME, str);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
