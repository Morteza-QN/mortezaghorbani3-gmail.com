package com.example.profile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_FULLNAME = "fullName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button saveInformationBtn = findViewById(R.id.btn_main_saveInformation);
        saveInformationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "user clicked in save information button", Toast.LENGTH_SHORT).show();
            }
        });


        CheckBox checkBoxAndroidDev = findViewById(R.id.chk_androidDeveloper);
        checkBoxAndroidDev.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) Toast.makeText(MainActivity.this, "android skill is checked", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, "android skill is not checked", Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBoxDeepLearning = findViewById(R.id.chk_deepLearning);
        checkBoxDeepLearning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) Toast.makeText(MainActivity.this, "deep Learning skill is checked", Toast.LENGTH_SHORT)
                                    .show();
                else Toast.makeText(MainActivity.this, "deep Learning skill is not checked", Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkboxUiDesign = findViewById(R.id.chk_uiDesign);
        checkboxUiDesign.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) Toast.makeText(MainActivity.this, "uiDesign skill is checked", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, "uiDesign skill is not checked", Toast.LENGTH_SHORT).show();
            }
        });


        RadioGroup radioGroup = findViewById(R.id.radioGroup_main);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rad_main_tehran:
                        Toast.makeText(MainActivity.this, "rad tehran", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad_main_karaj:
                        Toast.makeText(MainActivity.this, "rad karaj", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad_main_rasht:
                        Toast.makeText(MainActivity.this, "rad rasht", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        final Button editeProfileBtn = findViewById(R.id.btn_main_editProfile);
        editeProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent     = new Intent(MainActivity.this, EditProfileActivity.class);
                TextView fullNameTv = findViewById(R.id.tv_main_userName);
                intent.putExtra(EXTRA_KEY_FULLNAME, fullNameTv.getText());
                startActivityForResult(intent, 1001);
            }
        });


        Button viewWebsiteBtn = findViewById(R.id.btn_main_viewWebsite);
        viewWebsiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/morteza-qorbani/"));
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK && data != null) {
            String   s        = data.getStringExtra(EXTRA_KEY_FULLNAME);
            TextView textView = findViewById(R.id.tv_main_userName);
            textView.setText(s);
        }
    }
}
