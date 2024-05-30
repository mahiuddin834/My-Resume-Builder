package com.itnation.myresumebuilder.TemplateActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.itnation.myresumebuilder.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);




        // Retrieve the data from the Intent
        Intent intent = getIntent();

        String fullName = intent.getStringExtra("fullName");
        String position = intent.getStringExtra("position");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String website = intent.getStringExtra("website");
        String address = intent.getStringExtra("address");
        String aboutMe = intent.getStringExtra("aboutMe");

        String workEx1Start = intent.getStringExtra("workEx1Start");
        String workEx1End = intent.getStringExtra("workEx1End");
        String workEx1Company = intent.getStringExtra("workEx1Company");
        String workEx1Responsibilities = intent.getStringExtra("workEx1Responsibilities");

        String workEx2Start = intent.getStringExtra("workEx2Start");
        String workEx2End = intent.getStringExtra("workEx2End");
        String workEx2Company = intent.getStringExtra("workEx2Company");
        String workEx2Responsibilities = intent.getStringExtra("workEx2Responsibilities");

        String edu1Start = intent.getStringExtra("edu1Start");
        String edu1End = intent.getStringExtra("edu1End");
        String edu1Department = intent.getStringExtra("edu1Department");
        String edu1University = intent.getStringExtra("edu1University");

        String edu2Start = intent.getStringExtra("edu2Start");
        String edu2End = intent.getStringExtra("edu2End");
        String edu2Depertment = intent.getStringExtra("edu2Depertment");
        String edu2University = intent.getStringExtra("edu2University");

        String expertice1 = intent.getStringExtra("expertice1");
        String expertice2 = intent.getStringExtra("expertice2");
        String expertice3 = intent.getStringExtra("expertice3");
        String expertice4 = intent.getStringExtra("expertice4");
        String expertice5 = intent.getStringExtra("expertice5");
        String expertice6 = intent.getStringExtra("expertice6");

        String language1 = intent.getStringExtra("language1");
        String language2 = intent.getStringExtra("language2");
        String language3 = intent.getStringExtra("language3");
        String language4 = intent.getStringExtra("language4");
        String language5 = intent.getStringExtra("language5");
        String language6 = intent.getStringExtra("language6");

        String ref1Name = intent.getStringExtra("ref1Name");
        String ref1Position = intent.getStringExtra("ref1Position");
        String ref1Company = intent.getStringExtra("ref1Company");
        String ref1Email = intent.getStringExtra("ref1Email");
        String ref1Phone = intent.getStringExtra("ref1Phone");

        String ref2Name = intent.getStringExtra("ref2Name");
        String ref2Position = intent.getStringExtra("ref2Position");
        String ref2Company = intent.getStringExtra("ref2Company");
        String ref2Email = intent.getStringExtra("ref2Email");
        String ref2Phone = intent.getStringExtra("ref2Phone");

    }
}