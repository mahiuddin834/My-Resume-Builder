package com.itnation.myresumebuilder.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

public class ResumeDataInputActivity extends AppCompatActivity {

    ImageView profileImage;
    Button btnUploadPhoto, submitButton;
    EditText fullNameEditTxt, positionEditTxt, emailEditTxt, phoneEditTxt, websiteEditTxt, addressEditTxt;
    EditText aboutMeEditTxt;
    EditText workEx1StartDate, workEx1EndDate, workEx1CompanyNameEdtTxt, workEx1ResponsibilitieEdtTxt;
    EditText workEx2StartDate, workEx2EndDate, workEx2CompanyNameEdtTxt, workEx2ResponsibilitieEdtTxt;
    EditText workEx3StartDate, workEx3EndDate, workEx3CompanyNameEdtTxt, workEx3ResponsibilitieEdtTxt;
    EditText edu1StartEditTxt, edu1EndEditTxt, edu1DepartmentEdtTxt, edu1UniversityEdtTxt;
    EditText edu2StartEditTxt, edu2EndEditTxt, edu2DepartmentEditTxt, edu2UniversityEditTxt;
    EditText expertise1EdtTxt, expertise2EdtTxt, expertise3EdtTxt, expertise4EdtTxt, expertise5EdtTxt, expertise6EdtTxt;
    EditText language1EditTxt, language2EditTxt, language3EditTxt, language4EditTxt, language5EditTxt, language6EditTxt;
    EditText ref1NameEditTxt, ref1PositionEditTxt, ref1CompanyEditTxt, ref1EmailEditTxt, ref1PhoneEditTxt;
    EditText ref2NameEditTxt, ref2PositionEditTxt, ref2CompanyEditTxt, ref2EmailEditTxt, ref2PhoneEditTxt;

    private static final int REQUEST_CODE = 1;
    UserDataViewModel userDataViewModel;
    Bitmap selectedBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_data_input);

        userDataViewModel = new ViewModelProvider(this).get(UserDataViewModel.class);

        profileImage = findViewById(R.id.profile_image);
        btnUploadPhoto = findViewById(R.id.btn_upload_photo);
        submitButton = findViewById(R.id.submitButton);

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
        edu1DepartmentEdtTxt = findViewById(R.id.Edu1DepertmentEdtTxt);
        edu1UniversityEdtTxt = findViewById(R.id.Edu1UniversityEdtTxt);

        edu2StartEditTxt = findViewById(R.id.edu2StartEditTxt);
        edu2EndEditTxt = findViewById(R.id.edu2EndEditTxt);
        edu2DepartmentEditTxt = findViewById(R.id.edu2DepertmentEditTxt);
        edu2UniversityEditTxt = findViewById(R.id.edu2UniversityEditTxt);

        expertise1EdtTxt = findViewById(R.id.expertice1EdtTxt);
        expertise2EdtTxt = findViewById(R.id.expertice2EdtTxt);
        expertise3EdtTxt = findViewById(R.id.expertice3EdtTxt);
        expertise4EdtTxt = findViewById(R.id.expertice4EdtTxt);
        expertise5EdtTxt = findViewById(R.id.expertice5EdtTxt);
        expertise6EdtTxt = findViewById(R.id.expertice6EdtTxt);

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

        btnUploadPhoto.setOnClickListener(v -> openGallery());

        submitButton.setOnClickListener(view -> {
            if (areAllFieldsValid()) {
                getUserInputAndProceed();
                finish();
            } else {
                Toast.makeText(ResumeDataInputActivity.this, "Please fill in all the fields.", Toast.LENGTH_SHORT).show();
            }
        });
    }

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
                selectedBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                profileImage.setImageBitmap(selectedBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean areAllFieldsValid() {
        return !fullNameEditTxt.getText().toString().isEmpty() &&
                !positionEditTxt.getText().toString().isEmpty() &&
                !emailEditTxt.getText().toString().isEmpty() &&
                !phoneEditTxt.getText().toString().isEmpty() &&
                !addressEditTxt.getText().toString().isEmpty() &&
                !aboutMeEditTxt.getText().toString().isEmpty();
    }

    private void getUserInputAndProceed() {
        byte[] profileImageBytes = null;
        if (selectedBitmap != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            selectedBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            profileImageBytes = baos.toByteArray();
        }

        UserData userData = new UserData(0,
                fullNameEditTxt.getText().toString(),
                positionEditTxt.getText().toString(),
                emailEditTxt.getText().toString(),
                phoneEditTxt.getText().toString(),
                websiteEditTxt.getText().toString(),
                addressEditTxt.getText().toString(),
                aboutMeEditTxt.getText().toString(),
                workEx1StartDate.getText().toString(),
                workEx1EndDate.getText().toString(),
                workEx1CompanyNameEdtTxt.getText().toString(),
                workEx1ResponsibilitieEdtTxt.getText().toString(),
                workEx2StartDate.getText().toString(),
                workEx2EndDate.getText().toString(),
                workEx2CompanyNameEdtTxt.getText().toString(),
                workEx2ResponsibilitieEdtTxt.getText().toString(),
                workEx3StartDate.getText().toString(),
                workEx3EndDate.getText().toString(),
                workEx3CompanyNameEdtTxt.getText().toString(),
                workEx3ResponsibilitieEdtTxt.getText().toString(),
                edu1StartEditTxt.getText().toString(),
                edu1EndEditTxt.getText().toString(),
                edu1DepartmentEdtTxt.getText().toString(),
                edu1UniversityEdtTxt.getText().toString(),
                edu2StartEditTxt.getText().toString(),
                edu2EndEditTxt.getText().toString(),
                edu2DepartmentEditTxt.getText().toString(),
                edu2UniversityEditTxt.getText().toString(),
                expertise1EdtTxt.getText().toString(),
                expertise2EdtTxt.getText().toString(),
                expertise3EdtTxt.getText().toString(),
                expertise4EdtTxt.getText().toString(),
                expertise5EdtTxt.getText().toString(),
                expertise6EdtTxt.getText().toString(),
                language1EditTxt.getText().toString(),
                language2EditTxt.getText().toString(),
                language3EditTxt.getText().toString(),
                language4EditTxt.getText().toString(),
                language5EditTxt.getText().toString(),
                language6EditTxt.getText().toString(),
                ref1NameEditTxt.getText().toString(),
                ref1PositionEditTxt.getText().toString(),
                ref1CompanyEditTxt.getText().toString(),
                ref1EmailEditTxt.getText().toString(),
                ref1PhoneEditTxt.getText().toString(),
                ref2NameEditTxt.getText().toString(),
                ref2PositionEditTxt.getText().toString(),
                ref2CompanyEditTxt.getText().toString(),
                ref2EmailEditTxt.getText().toString(),
                ref2PhoneEditTxt.getText().toString(),
                profileImageBytes
        );

        userDataViewModel.insert(userData);
    }
}
