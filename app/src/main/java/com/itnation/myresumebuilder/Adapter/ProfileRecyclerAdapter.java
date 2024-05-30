package com.itnation.myresumebuilder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itnation.myresumebuilder.Activity.AllTemplateActivity;
import com.itnation.myresumebuilder.Activity.DataEditActivity;
import com.itnation.myresumebuilder.MVVM.UserData;
import com.itnation.myresumebuilder.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<ProfileRecyclerAdapter.ViewHolder> {

    private List<UserData> userDataList;

    Context context;
    public void setUserDataList(Context context, List<UserData> userDataList) {
        this.context =context;
        this.userDataList = userDataList;

    }

    @NonNull
    @Override
    public ProfileRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRecyclerAdapter.ViewHolder holder, int position) {


        UserData userData = userDataList.get(position);

        holder.profileName.setText(userData.getFullName());
        holder.positionTxt.setText(userData.getPosition());

        // Convert byte array to Bitmap
        byte[] profileImageBytes = userData.getProfileImage();
        if (profileImageBytes != null) {
            Bitmap profileBitmap = BitmapFactory.decodeByteArray(profileImageBytes, 0, profileImageBytes.length);
            holder.profileImage.setImageBitmap(profileBitmap);
        } else {
            holder.profileImage.setImageResource(R.drawable.man); // Set a default image if no image is available
        }


        holder.exportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, AllTemplateActivity.class);

                context.startActivity(intent);
            }
        });


        holder.editButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, DataEditActivity.class);

                // Save the profile image to a file and get the file path
                byte[] profileImageBytes = userData.getProfileImage();
                if (profileImageBytes != null) {
                    Bitmap profileBitmap = BitmapFactory.decodeByteArray(profileImageBytes, 0, profileImageBytes.length);
                    String imageFilePath = saveBitmapToFile(context, profileBitmap);
                    intent.putExtra("imageFilePath", imageFilePath);
                }

                intent.putExtra("userId", userData.getId());
                intent.putExtra("fullName", userData.getFullName());
                intent.putExtra("position", userData.getPosition());
                intent.putExtra("email", userData.getEmail());
                intent.putExtra("phone", userData.getPhone());
                intent.putExtra("website", userData.getWebsite());
                intent.putExtra("address", userData.getAddress());
                intent.putExtra("aboutMe", userData.getAboutMe());

                intent.putExtra("workEx1Start", userData.getWorkEx1StartDate());
                intent.putExtra("workEx1End", userData.getWorkEx1EndDate());
                intent.putExtra("workEx1Company", userData.getWorkEx1CompanyName());
                intent.putExtra("workEx1Responsibilities", userData.getWorkEx1Responsibilities());

                intent.putExtra("workEx2Start", userData.getWorkEx2StartDate());
                intent.putExtra("workEx2End", userData.getWorkEx2EndDate());
                intent.putExtra("workEx2Company", userData.getWorkEx2CompanyName());
                intent.putExtra("workEx2Responsibilities", userData.getWorkEx2Responsibilities());

                intent.putExtra("workEx3Start", userData.getWorkEx3StartDate());
                intent.putExtra("workEx3End", userData.getWorkEx3EndDate());
                intent.putExtra("workEx3Company", userData.getWorkEx3CompanyName());
                intent.putExtra("workEx3Responsibilities", userData.getWorkEx3Responsibilities());

                intent.putExtra("edu1Start", userData.getEdu1StartDate());
                intent.putExtra("edu1End", userData.getEdu1EndDate());
                intent.putExtra("edu1Department", userData.getEdu1Department());
                intent.putExtra("edu1University", userData.getEdu1University());

                intent.putExtra("edu2Start", userData.getEdu2StartDate());
                intent.putExtra("edu2End", userData.getEdu2EndDate());
                intent.putExtra("edu2Department", userData.getEdu2Department());
                intent.putExtra("edu2University", userData.getEdu2University());

                intent.putExtra("expertice1", userData.getExpertise1());
                intent.putExtra("expertice2", userData.getExpertise2());
                intent.putExtra("expertice3", userData.getExpertise3());
                intent.putExtra("expertice4", userData.getExpertise4());
                intent.putExtra("expertice5", userData.getExpertise5());
                intent.putExtra("expertice6", userData.getExpertise6());

                intent.putExtra("language1", userData.getLanguage1());
                intent.putExtra("language2", userData.getLanguage2());
                intent.putExtra("language3", userData.getLanguage3());
                intent.putExtra("language4", userData.getLanguage4());
                intent.putExtra("language5", userData.getLanguage5());
                intent.putExtra("language6", userData.getLanguage6());

                intent.putExtra("ref1Name", userData.getRef1Name());
                intent.putExtra("ref1Position", userData.getRef1Position());
                intent.putExtra("ref1Company", userData.getRef1Company());
                intent.putExtra("ref1Email", userData.getRef1Email());
                intent.putExtra("ref1Phone", userData.getRef1Phone());

                intent.putExtra("ref2Name", userData.getRef2Name());
                intent.putExtra("ref2Position", userData.getRef2Position());
                intent.putExtra("ref2Company", userData.getRef2Company());
                intent.putExtra("ref2Email", userData.getRef2Email());
                intent.putExtra("ref2Phone", userData.getRef2Phone());

                context.startActivity(intent);



            }
        });



    }

    private String saveBitmapToFile(Context context, Bitmap bitmap) {
        File filesDir = context.getFilesDir();
        File imageFile = new File(filesDir, "profile_image_" + System.currentTimeMillis() + ".png");

        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageFile.getAbsolutePath();
    }




    @Override
    public int getItemCount() {
        return userDataList == null ? 0 : userDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profileImage;
        TextView profileName, positionTxt;
        Button editButtton, exportButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.profileImage);
            profileName = itemView.findViewById(R.id.profileName);
            positionTxt = itemView.findViewById(R.id.positionTxt);
            editButtton = itemView.findViewById(R.id.editButtton);
            exportButton = itemView.findViewById(R.id.exportButton);

        }
    }
}
