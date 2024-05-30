package com.itnation.myresumebuilder.TemplateActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.itnation.myresumebuilder.MVVM.UserData;
import com.itnation.myresumebuilder.MVVM.UserDataViewModel;
import com.itnation.myresumebuilder.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class FirstActivity extends AppCompatActivity {

    // Declare all views as fields
    private View view;
    private ScrollView mainScroll;
    private ImageView profileImage;
    private TextView fullName, position, contactInfo, educationInfo, expertise, language,
            referenceOne, referenceTwo, aboutMe, workExperienceOneStartEnd,
            workExperienceOnePosition, workExperienceOneResponsibilities,
            workExperienceTwoStartEnd, workExperienceTwoPosition,
            workExperienceTwoResponsibilities, workExperienceThreeStartEnd,
            workExperienceThreePosition, workExperienceThreeResponsibilities;

    Button export_button;
    String fullNameIntent;
    CircleImageView profileImageView;

    UserDataViewModel userDataViewModel;

    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        // Initialize ViewModel
        userDataViewModel = new ViewModelProvider(this).get(UserDataViewModel.class);






        // Initialize views using findViewById
        profileImageView = findViewById(R.id.profile_image);
        view = findViewById(R.id.view);
        export_button = findViewById(R.id.export_button);
        mainScroll = findViewById(R.id.mainScroll);
        fullName = findViewById(R.id.fullName);
        position = findViewById(R.id.positin);  // Correct typo: positin should be position in XML
        contactInfo = findViewById(R.id.contactInfo);
        educationInfo = findViewById(R.id.educationInfo);
        expertise = findViewById(R.id.expertise);
        language = findViewById(R.id.language);
        referenceOne = findViewById(R.id.referenceOne);
        referenceTwo = findViewById(R.id.referenceTwo);
        aboutMe = findViewById(R.id.aboutMe);
        workExperienceOneStartEnd = findViewById(R.id.workExpreanceOneStartEnd);
        workExperienceOnePosition = findViewById(R.id.workExpreanceOnePosition);
        workExperienceOneResponsibilities = findViewById(R.id.workExpreanceOneResposibilitie);
        workExperienceTwoStartEnd = findViewById(R.id.workExpreanceTwoStartEnd);
        workExperienceTwoPosition = findViewById(R.id.workExpreanceTwoPosition);
        workExperienceTwoResponsibilities = findViewById(R.id.workExpreanceTwoResposibilitie);
        workExperienceThreeStartEnd = findViewById(R.id.workExpreanceThreeStartEnd);
        workExperienceThreePosition = findViewById(R.id.workExpreanceThreePosition);
        workExperienceThreeResponsibilities = findViewById(R.id.workExpreanceThreeResposibilitie);




        /*


        // Observe and set UserData
        userDataViewModel.getUserDataById(1).observe(this, new Observer<UserData>() {
            @Override
            public void onChanged(@Nullable UserData userData) {
                if (userData != null) {

                    fullName.setText(userData.getFullName());
                    position.setText(userData.getPosition());

                    String contact_info = userData.getEmail() + "\n" + userData.getPhone() + "\n" +userData.getWebsite() + "\n" + userData.getAddress();
                    contactInfo.setText(contact_info);


                    aboutMe.setText(userData.getAboutMe());


                    String workExpreOneStartEnd_info = userData.getWorkEx1Start() + " - " + userData.getWorkEx1End();
                    workExperienceOneStartEnd.setText(workExpreOneStartEnd_info);
                    workExperienceOnePosition.setText(userData.getWorkEx1Company());
                    workExperienceOneResponsibilities.setText(userData.getWorkEx1Responsibilities());

                    String workExpreTwoStartEnd_info = userData.getWorkEx2Start() + " - " + userData.getWorkEx2End();
                    workExperienceTwoStartEnd.setText(workExpreTwoStartEnd_info);
                    workExperienceTwoPosition.setText(userData.getWorkEx2Company());
                    workExperienceTwoResponsibilities.setText(userData.getWorkEx2Responsibilities());

                    String workExpreThreeStartEnd_info = userData.getWorkEx3Start() + " - " + userData.getWorkEx3End();
                    workExperienceThreeStartEnd.setText(workExpreThreeStartEnd_info);
                    workExperienceThreePosition.setText(userData.getWorkEx2Company());
                    workExperienceThreeResponsibilities.setText(userData.getWorkEx2Responsibilities());



                    String educationOne_info = userData.getEdu1Start() + " - " + userData.getEdu1End() + "\n" + userData.getEdu1Department() + "\n" + userData.getEdu1University() ;

                    String educationTwo_info = userData.getEdu2Start() + " - " + userData.getEdu2End() + "\n" + userData.getEdu2Department() + "\n" + userData.getEdu2University() ;

                    educationInfo.setText(educationOne_info + "\n\n\n" + educationTwo_info);



                    String expertise_info = userData.getExpertise1() + "\n" +userData.getExpertise2() + "\n" + userData.getExpertise3() + "\n" + userData.getExpertise4() + "\n" + userData.getExpertise5() + "\n" + userData.getExpertise6() ;

                    expertise.setText(expertise_info);



                    String language_info = userData.getLanguage1() + "\n" +userData.getLanguage2() + "\n" + userData.getLanguage3() + "\n" + userData.getLanguage4() + "\n" + userData.getLanguage5() + "\n" + userData.getLanguage6() ;

                    language.setText(language_info);




                    String referenceOne_info = userData.getRef1Name()+ "\n" + userData.getRef1Position() + "\n" +userData.getRef1Company() + "\n" + userData.getRef1Email() + "\n" + userData.getRef1Phone();
                    String referenceTwo_info = userData.getRef2Name()+ "\n" + userData.getRef2Position() + "\n" +userData.getRef2Company() + "\n" + userData.getRef2Email() + "\n" + userData.getRef2Phone();

                    referenceOne.setText(referenceOne_info);
                    referenceTwo.setText(referenceTwo_info);

                }
            }
        });




         */



        export_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                showCustomAlertDialog();

                export_button.setVisibility(View.GONE);

            }
        });







    }//================== close OnCreate =======================


    private void getSetString(){



        /*
        // Retrieve the data from the Intent
        Intent intent = getIntent();

        String imageUriString = intent.getStringExtra("imageUri");

        fullNameIntent = intent.getStringExtra("fullName");
        String positionIntent = intent.getStringExtra("position");
        String emailIntent = intent.getStringExtra("email");
        String phoneIntent = intent.getStringExtra("phone");
        String websiteIntent = intent.getStringExtra("website");
        String addressIntent = intent.getStringExtra("address");
        String contact_info = emailIntent + "\n" + phoneIntent + "\n" +websiteIntent + "\n" + addressIntent;

        String aboutMeIntent = intent.getStringExtra("aboutMe");

        String workEx1StartIntent = intent.getStringExtra("workEx1Start");
        String workEx1EndIntent = intent.getStringExtra("workEx1End");
        String workEx1CompanyIntent = intent.getStringExtra("workEx1Company");
        String workEx1ResponsibilitiesIntent = intent.getStringExtra("workEx1Responsibilities");

        String workExpreOneStartEnd_info = workEx1StartIntent + " - " + workEx1EndIntent;


        String workEx2StartIntent = intent.getStringExtra("workEx2Start");
        String workEx2EndIntent = intent.getStringExtra("workEx2End");
        String workEx2CompanyIntent = intent.getStringExtra("workEx2Company");
        String workEx2ResponsibilitiesIntent = intent.getStringExtra("workEx2Responsibilities");

        String workExpreTwoStartEnd_info = workEx2StartIntent + " - " + workEx2EndIntent;


        String workEx3StartIntent = intent.getStringExtra("workEx3Start");
        String workEx3EndIntent = intent.getStringExtra("workEx3End");
        String workEx3CompanyIntent = intent.getStringExtra("workEx3Company");
        String workEx3ResponsibilitiesIntent = intent.getStringExtra("workEx3Responsibilities");

        String workExpreThreeStartEnd_info = workEx3StartIntent + " - " + workEx3EndIntent;


        String edu1StartIntent = intent.getStringExtra("edu1Start");
        String edu1EndIntent = intent.getStringExtra("edu1End");
        String edu1DepartmentIntent = intent.getStringExtra("edu1Department");
        String edu1UniversityIntent = intent.getStringExtra("edu1University");

        String educationOne_info = edu1StartIntent + " - " + edu1EndIntent + "\n" + edu1DepartmentIntent + "\n" + edu1UniversityIntent ;

        String edu2StartIntent = intent.getStringExtra("edu2Start");
        String edu2EndIntent = intent.getStringExtra("edu2End");
        String edu2DepertmentIntent = intent.getStringExtra("edu2Depertment");
        String edu2UniversityIntent = intent.getStringExtra("edu2University");

        String educationTwo_info = edu2StartIntent + " - " + edu2EndIntent + "\n" + edu2DepertmentIntent + "\n" + edu2UniversityIntent ;


        String expertice1Intent = intent.getStringExtra("expertice1");
        String expertice2Intent = intent.getStringExtra("expertice2");
        String expertice3Intent = intent.getStringExtra("expertice3");
        String expertice4Intent = intent.getStringExtra("expertice4");
        String expertice5Intent = intent.getStringExtra("expertice5");
        String expertice6Intent = intent.getStringExtra("expertice6");

        String expertise_info = expertice1Intent + "\n" +expertice2Intent + "\n" + expertice3Intent + "\n" + expertice4Intent + "\n" + expertice5Intent + "\n" + expertice6Intent ;

        String language1Intent = intent.getStringExtra("language1");
        String language2Intent = intent.getStringExtra("language2");
        String language3Intent = intent.getStringExtra("language3");
        String language4Intent = intent.getStringExtra("language4");
        String language5Intent = intent.getStringExtra("language5");
        String language6Intent = intent.getStringExtra("language6");

        String language_info = language1Intent + "\n" +language2Intent + "\n" + language3Intent + "\n" + language4Intent + "\n" + language5Intent + "\n" + language6Intent ;


        String ref1NameIntent = intent.getStringExtra("ref1Name");
        String ref1PositionIntent = intent.getStringExtra("ref1Position");
        String ref1CompanyIntent = intent.getStringExtra("ref1Company");
        String ref1EmailIntent = intent.getStringExtra("ref1Email");
        String ref1PhoneIntent = intent.getStringExtra("ref1Phone");

        String referenceOne_info = ref1NameIntent + "\n" +ref1PositionIntent + "\n" + ref1CompanyIntent + "\n" + ref1EmailIntent + "\n" + ref1PhoneIntent;



        String ref2NameIntent = intent.getStringExtra("ref2Name");
        String ref2PositionIntent = intent.getStringExtra("ref2Position");
        String ref2CompanyIntent = intent.getStringExtra("ref2Company");
        String ref2EmailIntent = intent.getStringExtra("ref2Email");
        String ref2PhoneIntent = intent.getStringExtra("ref2Phone");

        String referenceTwo_info = ref2NameIntent + "\n" +ref2PositionIntent + "\n" + ref2CompanyIntent + "\n" + ref2EmailIntent + "\n" + ref2PhoneIntent;




//Setting All data to resume ---------------------


        if (imageUriString != null) {
            imageUri = Uri.parse(imageUriString);
            profileImageView.setImageURI(imageUri);
        }

        fullName.setText(fullNameIntent);
        position.setText(positionIntent);
        contactInfo.setText(contact_info);
        educationInfo.setText(educationOne_info + "\n\n\n" + educationTwo_info);
        expertise.setText(expertise_info);
        language.setText(language_info);
        referenceOne.setText(referenceOne_info);
        referenceTwo.setText(referenceTwo_info);
        aboutMe.setText(aboutMeIntent);

        workExperienceOneStartEnd.setText(workExpreOneStartEnd_info);
        workExperienceOnePosition.setText(workEx1CompanyIntent);
        workExperienceOneResponsibilities.setText(workEx1ResponsibilitiesIntent);

        workExperienceTwoStartEnd.setText(workExpreTwoStartEnd_info);
        workExperienceTwoPosition.setText(workEx2CompanyIntent);
        workExperienceTwoResponsibilities.setText(workEx2ResponsibilitiesIntent);

        workExperienceThreeStartEnd.setText(workExpreThreeStartEnd_info);
        workExperienceThreePosition.setText(workEx3CompanyIntent);
        workExperienceThreeResponsibilities.setText(workEx3ResponsibilitiesIntent);




         */


    }//----------------------------------


    private static final int REQUEST_WRITE_STORAGE = 112;


    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_STORAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                convertLayoutToPdf();
            } else {
                // Permission denied
            }
        }
    }

    ConstraintLayout main;
    private void convertLayoutToPdf() {
        // Get the current ScrollView content
        View view = findViewById(R.id.main);
        //View view = LayoutInflater.from(this).inflate(R.layout.activity_first, null);

        // Define A4 size in points (1 inch = 72 points, A4 size is 8.27 x 11.69 inches)
        int pageWidth = 1000;
        int pageHeight = 1500;

        // Define margin sizes (in points)
        int marginLeft = 40;
        int marginTop = 40;
        int marginRight = 40;
        int marginBottom = 40;

        // Calculate content width and height by subtracting margins
        int contentWidth = pageWidth - marginLeft - marginRight;
        int contentHeightPerPage = pageHeight - marginTop - marginBottom;

        // Measure the content with the content width and unspecified height
        view.measure(View.MeasureSpec.makeMeasureSpec(contentWidth, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        int totalContentHeight = view.getMeasuredHeight();
        int totalPages = (int) Math.ceil((double) totalContentHeight / contentHeightPerPage);

        PdfDocument pdfDocument = new PdfDocument();

        for (int i = 0; i < totalPages; i++) {
            int startY = i * contentHeightPerPage;

            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(pageWidth, pageHeight, i + 1).create();
            PdfDocument.Page page = pdfDocument.startPage(pageInfo);

            Canvas canvas = page.getCanvas();
            // Move the canvas to the start of the current page, taking margins into account
            canvas.translate(marginLeft, marginTop - startY);
            view.draw(canvas);

            pdfDocument.finishPage(page);
        }

        // Generate a random file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        int randomNum = new Random().nextInt(1000); // Generate a random number between 0 and 999
        String fileName = fullNameIntent + "Resume_" + timeStamp + "_" + randomNum + ".pdf";

        // Save the document
        File downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        File file = new File(downloadDirectory, fileName);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            pdfDocument.writeTo(fileOutputStream);
            Toast.makeText(this, "Resume Exported", Toast.LENGTH_SHORT).show();

            // Open the exported PDF file using an Intent (same as before)
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", file);
            intent.setDataAndType(uri, "application/pdf");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error exporting resume", Toast.LENGTH_SHORT).show();
        } finally {
            pdfDocument.close();
        }
    }




    private void showCustomAlertDialog() {
        // Inflate the custom layout/view
        LayoutInflater inflater = LayoutInflater.from(this);
        View customView = inflater.inflate(R.layout.alert_dialog_item, null);

        // Create an AlertDialog.Builder and set the view to the custom layout
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(customView);

        // Get the EditText and Button views from the custom layout
        Button positiveButton = customView.findViewById(R.id.positiveButton);
        Button negativeButton = customView.findViewById(R.id.negativeButton);

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();

        // Set the onClickListener for the positive button
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle positive button click

                if (checkPermission()) {
                    convertLayoutToPdf();
                } else {
                    requestPermission();
                }
                // Do something with the input
                alertDialog.dismiss();
            }
        });


        // Set the onClickListener for the negative button
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle negative button click
                alertDialog.dismiss();
            }
        });


        alertDialog.show();

    }

}