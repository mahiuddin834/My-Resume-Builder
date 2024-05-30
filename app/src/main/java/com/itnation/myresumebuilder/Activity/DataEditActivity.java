package com.itnation.myresumebuilder.Activity;



import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import com.itnation.myresumebuilder.MVVM.UserData;
import com.itnation.myresumebuilder.MVVM.UserDataViewModel;
import com.itnation.myresumebuilder.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DataEditActivity extends AppCompatActivity {


    private static final int PICK_IMAGE_REQUEST = 1;
    private Bitmap selectedBitmap;

    private UserDataViewModel userDataViewModel;

    ImageView profileImage;
    Button btnUploadPhoto;
    EditText fullNameEditTxt, positionEditTxt, emailEditTxt, phoneEditTxt, websiteEditTxt, addressEditTxt;
    EditText aboutMeEditTxt;
    EditText workEx1StartDate, workEx1EndDate, workEx1CompanyNameEdtTxt, workEx1ResponsibilitieEdtTxt;
    EditText workEx2StartDate, workEx2EndDate, workEx2CompanyNameEdtTxt, workEx2ResponsibilitieEdtTxt;
    EditText workEx3StartDate, workEx3EndDate, workEx3CompanyNameEdtTxt, workEx3ResponsibilitieEdtTxt;
    EditText edu1StartEditTxt, edu1EndEditTxt, edu1DepertmentEdtTxt, edu1UniversityEdtTxt;

    EditText edu2StartEditTxt, edu2EndEditTxt, edu2DepertmentEditTxt, edu2UniversityEditTxt;
    EditText expertice1EdtTxt, expertice2EdtTxt, expertice3EdtTxt, expertice4EdtTxt, expertice5EdtTxt, expertice6EdtTxt;
    EditText language1EditTxt, language2EditTxt, language3EditTxt, language4EditTxt, language5EditTxt, language6EditTxt;
    EditText ref1NameEditTxt, ref1PositionEditTxt, ref1CompanyEditTxt, ref1EmailEditTxt, ref1PhoneEditTxt;
    EditText ref2NameEditTxt, ref2PositionEditTxt, ref2CompanyEditTxt, ref2EmailEditTxt, ref2PhoneEditTxt;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_edit);


        userDataViewModel = new ViewModelProvider(this).get(UserDataViewModel.class);

        profileImage = findViewById(R.id.profile_image);
        btnUploadPhoto = findViewById(R.id.btn_upload_photo);

        fullNameEditTxt = findViewById(R.id.fullNameEditTxt);
        positionEditTxt = findViewById(R.id.positionEditTxt);
        emailEditTxt = findViewById(R.id.emailEditTxt);
        phoneEditTxt = findViewById(R.id.phoneEditTxt);
        websiteEditTxt = findViewById(R.id.websiteEditTxt);
        addressEditTxt = findViewById(R.id.addressEditTxt);

        aboutMeEditTxt = findViewById(R.id.aboutMeEditTxt);

        workEx1StartDate = findViewById(R.id.workEx1StartDate);
        workEx1EndDate = findViewById(R.id.workEx1EndDate);
        workEx1CompanyNameEdtTxt = findViewById(R.id.workEx1CompanyNameEdtTxt);
        workEx1ResponsibilitieEdtTxt = findViewById(R.id.workEx1ResponsibilitieEdtTxt);

        workEx2StartDate = findViewById(R.id.workEx2StartDate);
        workEx2EndDate = findViewById(R.id.workEx2EndDate);
        workEx2CompanyNameEdtTxt = findViewById(R.id.workEx2CompanyNameEdtTxt);
        workEx2ResponsibilitieEdtTxt = findViewById(R.id.workEx2ResponsibilitieEdtTxt);

        workEx3StartDate = findViewById(R.id.workEx3StartDate);
        workEx3EndDate = findViewById(R.id.workEx3EndDate);
        workEx3CompanyNameEdtTxt = findViewById(R.id.workEx3CompanyNameEdtTxt);
        workEx3ResponsibilitieEdtTxt = findViewById(R.id.workEx3ResponsibilitieEdtTxt);

        edu1StartEditTxt = findViewById(R.id.Edu1StartEditTxt);
        edu1EndEditTxt = findViewById(R.id.Edu1EndEditTxt);
        edu1DepertmentEdtTxt = findViewById(R.id.Edu1DepertmentEdtTxt);
        edu1UniversityEdtTxt = findViewById(R.id.Edu1UniversityEdtTxt);

        edu2StartEditTxt = findViewById(R.id.edu2StartEditTxt);
        edu2EndEditTxt = findViewById(R.id.edu2EndEditTxt);
        edu2DepertmentEditTxt = findViewById(R.id.edu2DepertmentEditTxt);
        edu2UniversityEditTxt = findViewById(R.id.edu2UniversityEditTxt);

        expertice1EdtTxt = findViewById(R.id.expertice1EdtTxt);
        expertice2EdtTxt = findViewById(R.id.expertice2EdtTxt);
        expertice3EdtTxt = findViewById(R.id.expertice3EdtTxt);
        expertice4EdtTxt = findViewById(R.id.expertice4EdtTxt);
        expertice5EdtTxt = findViewById(R.id.expertice5EdtTxt);
        expertice6EdtTxt = findViewById(R.id.expertice6EdtTxt);

        language1EditTxt = findViewById(R.id.language1EditTxt);
        language2EditTxt = findViewById(R.id.language2EditTxt);
        language3EditTxt = findViewById(R.id.language3EditTxt);
        language4EditTxt = findViewById(R.id.language4EditTxt);
        language5EditTxt = findViewById(R.id.language5EditTxt);
        language6EditTxt = findViewById(R.id.language6EditTxt);

        ref1NameEditTxt = findViewById(R.id.ref1NameEditTxt);
        ref1PositionEditTxt = findViewById(R.id.ref1PositionEditTxt);
        ref1CompanyEditTxt = findViewById(R.id.ref1CompanyEditTxt);
        ref1EmailEditTxt = findViewById(R.id.ref1EmailEditTxt);
        ref1PhoneEditTxt = findViewById(R.id.ref1PhoneEditTxt);

        ref2NameEditTxt = findViewById(R.id.ref2NameEditTxt);
        ref2PositionEditTxt = findViewById(R.id.ref2PositionEditTxt);
        ref2CompanyEditTxt = findViewById(R.id.ref2CompanyEditTxt);
        ref2EmailEditTxt = findViewById(R.id.ref2EmailEditTxt);
        ref2PhoneEditTxt = findViewById(R.id.ref2PhoneEditTxt);

        submitButton = findViewById(R.id.submitButton);




        loadFromIntent();






        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();

            }
        });


        btnUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGallery();

            }
        });


    }//-------------------------

    private static final int REQUEST_CODE = 1;


    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                selectedBitmap= MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                profileImage.setImageBitmap(selectedBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    private void loadFromIntent() {
        Intent intent = getIntent();

        String imageFilePath = intent.getStringExtra("imageFilePath");
        if (imageFilePath != null) {
            Bitmap profileBitmap = loadBitmapFromFile(imageFilePath);
            profileImage.setImageBitmap(profileBitmap);
        } else {
            profileImage.setImageResource(R.drawable.man); // Set a default image if no image is available
        }

        // Load other data from the intent and set EditText fields accordingly
        String fullNameIntent = intent.getStringExtra("fullName");
        fullNameEditTxt.setText(fullNameIntent);
        String positionIntent = intent.getStringExtra("position");
        positionEditTxt.setText(positionIntent);
        String emailIntent = intent.getStringExtra("email");
        emailEditTxt.setText(emailIntent);
        String phoneIntent = intent.getStringExtra("phone");
        phoneEditTxt.setText(phoneIntent);
        String websiteIntent = intent.getStringExtra("website");
        websiteEditTxt.setText(websiteIntent);
        String addressIntent = intent.getStringExtra("address");
        addressEditTxt.setText(addressIntent);

        String aboutMeIntent = intent.getStringExtra("aboutMe");
        aboutMeEditTxt.setText(aboutMeIntent);

        String workEx1StartIntent = intent.getStringExtra("workEx1Start");
        String workEx1EndIntent = intent.getStringExtra("workEx1End");
        String workEx1CompanyIntent = intent.getStringExtra("workEx1Company");
        String workEx1ResponsibilitiesIntent = intent.getStringExtra("workEx1Responsibilities");

        workEx1StartDate.setText(workEx1StartIntent);
        workEx1EndDate.setText(workEx1EndIntent);
        workEx1CompanyNameEdtTxt.setText(workEx1CompanyIntent);
        workEx1ResponsibilitieEdtTxt.setText(workEx1ResponsibilitiesIntent);

        String workEx2StartIntent = intent.getStringExtra("workEx2Start");
        String workEx2EndIntent = intent.getStringExtra("workEx2End");
        String workEx2CompanyIntent = intent.getStringExtra("workEx2Company");
        String workEx2ResponsibilitiesIntent = intent.getStringExtra("workEx2Responsibilities");

        workEx2StartDate.setText(workEx2StartIntent);
        workEx2EndDate.setText(workEx2EndIntent);
        workEx2CompanyNameEdtTxt.setText(workEx2CompanyIntent);
        workEx2ResponsibilitieEdtTxt.setText(workEx2ResponsibilitiesIntent);

        String workEx3StartIntent = intent.getStringExtra("workEx3Start");
        String workEx3EndIntent = intent.getStringExtra("workEx3End");
        String workEx3CompanyIntent = intent.getStringExtra("workEx3Company");
        String workEx3ResponsibilitiesIntent = intent.getStringExtra("workEx3Responsibilities");

        workEx3StartDate.setText(workEx3StartIntent);
        workEx3EndDate.setText(workEx3EndIntent);
        workEx3CompanyNameEdtTxt.setText(workEx3CompanyIntent);
        workEx3ResponsibilitieEdtTxt.setText(workEx3ResponsibilitiesIntent);

        String edu1StartIntent = intent.getStringExtra("edu1Start");
        String edu1EndIntent = intent.getStringExtra("edu1End");
        String edu1DepartmentIntent = intent.getStringExtra("edu1Department");
        String edu1UniversityIntent = intent.getStringExtra("edu1University");

        edu1StartEditTxt.setText(edu1StartIntent);
        edu1EndEditTxt.setText(edu1EndIntent);
        edu1DepertmentEdtTxt.setText(edu1DepartmentIntent);
        edu1UniversityEdtTxt.setText(edu1UniversityIntent);

        String edu2StartIntent = intent.getStringExtra("edu2Start");
        String edu2EndIntent = intent.getStringExtra("edu2End");
        String edu2DepertmentIntent = intent.getStringExtra("edu2Depertment");
        String edu2UniversityIntent = intent.getStringExtra("edu2University");

        edu2StartEditTxt.setText(edu2StartIntent);
        edu2EndEditTxt.setText(edu2EndIntent);
        edu2DepertmentEditTxt.setText(edu2DepertmentIntent);
        edu2UniversityEditTxt.setText(edu2UniversityIntent);

        String expertice1Intent = intent.getStringExtra("expertice1");
        String expertice2Intent = intent.getStringExtra("expertice2");
        String expertice3Intent = intent.getStringExtra("expertice3");
        String expertice4Intent = intent.getStringExtra("expertice4");
        String expertice5Intent = intent.getStringExtra("expertice5");
        String expertice6Intent = intent.getStringExtra("expertice6");

        expertice1EdtTxt.setText(expertice1Intent);
        expertice2EdtTxt.setText(expertice2Intent);
        expertice3EdtTxt.setText(expertice3Intent);
        expertice4EdtTxt.setText(expertice4Intent);
        expertice5EdtTxt.setText(expertice5Intent);
        expertice6EdtTxt.setText(expertice6Intent);

        String language1Intent = intent.getStringExtra("language1");
        String language2Intent = intent.getStringExtra("language2");
        String language3Intent = intent.getStringExtra("language3");
        String language4Intent = intent.getStringExtra("language4");
        String language5Intent = intent.getStringExtra("language5");
        String language6Intent = intent.getStringExtra("language6");

        language1EditTxt.setText(language1Intent);
        language2EditTxt.setText(language2Intent);
        language3EditTxt.setText(language3Intent);
        language4EditTxt.setText(language4Intent);
        language5EditTxt.setText(language5Intent);
        language6EditTxt.setText(language6Intent);

        String ref1NameIntent = intent.getStringExtra("ref1Name");
        String ref1PositionIntent = intent.getStringExtra("ref1Position");
        String ref1CompanyIntent = intent.getStringExtra("ref1Company");
        String ref1EmailIntent = intent.getStringExtra("ref1Email");
        String ref1PhoneIntent = intent.getStringExtra("ref1Phone");

        ref1NameEditTxt.setText(ref1NameIntent);
        ref1PositionEditTxt.setText(ref1PositionIntent);
        ref1CompanyEditTxt.setText(ref1CompanyIntent);
        ref1EmailEditTxt.setText(ref1EmailIntent);
        ref1PhoneEditTxt.setText(ref1PhoneIntent);

        String ref2NameIntent = intent.getStringExtra("ref2Name");
        String ref2PositionIntent = intent.getStringExtra("ref2Position");
        String ref2CompanyIntent = intent.getStringExtra("ref2Company");
        String ref2EmailIntent = intent.getStringExtra("ref2Email");
        String ref2PhoneIntent = intent.getStringExtra("ref2Phone");

        ref2NameEditTxt.setText(ref2NameIntent);
        ref2PositionEditTxt.setText(ref2PositionIntent);
        ref2CompanyEditTxt.setText(ref2CompanyIntent);
        ref2EmailEditTxt.setText(ref2EmailIntent);
        ref2PhoneEditTxt.setText(ref2PhoneIntent);
    }


    private Bitmap loadBitmapFromFile(String filePath) {
        return BitmapFactory.decodeFile(filePath);
    }

    ///==========================================



    private void saveData() {
        // Collect data from EditText fields
        int userId = getIntent().getIntExtra("userId", -1);
        String fullName = fullNameEditTxt.getText().toString();
        String position = positionEditTxt.getText().toString();
        String email = emailEditTxt.getText().toString();
        String phone = phoneEditTxt.getText().toString();
        String website = websiteEditTxt.getText().toString();
        String address = addressEditTxt.getText().toString();
        String aboutMe = aboutMeEditTxt.getText().toString();

        String workEx1Start = workEx1StartDate.getText().toString();
        String workEx1End = workEx1EndDate.getText().toString();
        String workEx1Company = workEx1CompanyNameEdtTxt.getText().toString();
        String workEx1Responsibilities = workEx1ResponsibilitieEdtTxt.getText().toString();

        String workEx2Start = workEx2StartDate.getText().toString();
        String workEx2End = workEx2EndDate.getText().toString();
        String workEx2Company = workEx2CompanyNameEdtTxt.getText().toString();
        String workEx2Responsibilities = workEx2ResponsibilitieEdtTxt.getText().toString();

        String workEx3Start = workEx3StartDate.getText().toString();
        String workEx3End = workEx3EndDate.getText().toString();
        String workEx3Company = workEx3CompanyNameEdtTxt.getText().toString();
        String workEx3Responsibilities = workEx3ResponsibilitieEdtTxt.getText().toString();

        String edu1Start = edu1StartEditTxt.getText().toString();
        String edu1End = edu1EndEditTxt.getText().toString();
        String edu1Department = edu1DepertmentEdtTxt.getText().toString();
        String edu1University = edu1UniversityEdtTxt.getText().toString();

        String edu2Start = edu2StartEditTxt.getText().toString();
        String edu2End = edu2EndEditTxt.getText().toString();
        String edu2Department = edu2DepertmentEditTxt.getText().toString();
        String edu2University = edu2UniversityEditTxt.getText().toString();

        String expertice1 = expertice1EdtTxt.getText().toString();
        String expertice2 = expertice2EdtTxt.getText().toString();
        String expertice3 = expertice3EdtTxt.getText().toString();
        String expertice4 = expertice4EdtTxt.getText().toString();
        String expertice5 = expertice5EdtTxt.getText().toString();
        String expertice6 = expertice6EdtTxt.getText().toString();

        String language1 = language1EditTxt.getText().toString();
        String language2 = language2EditTxt.getText().toString();
        String language3 = language3EditTxt.getText().toString();
        String language4 = language4EditTxt.getText().toString();
        String language5 = language5EditTxt.getText().toString();
        String language6 = language6EditTxt.getText().toString();

        String ref1Name = ref1NameEditTxt.getText().toString();
        String ref1Position = ref1PositionEditTxt.getText().toString();
        String ref1Company = ref1CompanyEditTxt.getText().toString();
        String ref1Email = ref1EmailEditTxt.getText().toString();
        String ref1Phone = ref1PhoneEditTxt.getText().toString();

        String ref2Name = ref2NameEditTxt.getText().toString();
        String ref2Position = ref2PositionEditTxt.getText().toString();
        String ref2Company = ref2CompanyEditTxt.getText().toString();
        String ref2Email = ref2EmailEditTxt.getText().toString();
        String ref2Phone = ref2PhoneEditTxt.getText().toString();

        // Retrieve the profile image byte array from the intent
        byte[] profileImageBytes = null;
        if (selectedBitmap != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            selectedBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            profileImageBytes = baos.toByteArray();
        }

        // Create a UserData object with the collected data
        UserData userData = new UserData(userId, fullName, position, email, phone, website, address, aboutMe,
                workEx1Start, workEx1End, workEx1Company, workEx1Responsibilities,
                workEx2Start, workEx2End, workEx2Company, workEx2Responsibilities,
                workEx3Start, workEx3End, workEx3Company, workEx3Responsibilities,
                edu1Start, edu1End, edu1Department, edu1University,
                edu2Start, edu2End, edu2Department, edu2University,
                expertice1, expertice2, expertice3, expertice4, expertice5, expertice6,
                language1, language2, language3, language4, language5, language6,
                ref1Name, ref1Position, ref1Company, ref1Email, ref1Phone,
                ref2Name, ref2Position, ref2Company, ref2Email, ref2Phone,
                profileImageBytes);  // Add profileImage as the last parameter

        // Update the data in the database
        userDataViewModel.updateUserData(userData);

        // Optionally, show a confirmation message or close the activity
        Toast.makeText(DataEditActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
        finish();
    }



}