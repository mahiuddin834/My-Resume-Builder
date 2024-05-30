package com.itnation.myresumebuilder.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itnation.myresumebuilder.Adapter.TemplateAdapter;
import com.itnation.myresumebuilder.Model.TemplateModel;
import com.itnation.myresumebuilder.R;

import java.util.ArrayList;

public class AllTemplateActivity extends AppCompatActivity {

    RecyclerView templateRv;

    TemplateAdapter templateAdapter;
    TemplateModel templateModel;

    ArrayList<TemplateModel> templateModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_template);


        templateRv= findViewById(R.id.templateRv);




        templateModelArrayList= new ArrayList<>();
        templateModelArrayList.add(new TemplateModel("First", R.drawable.first));
        templateModelArrayList.add(new TemplateModel("Second", R.drawable.second));
        templateModelArrayList.add(new TemplateModel("Third", R.drawable.third));
        templateModelArrayList.add(new TemplateModel("Fourth", R.drawable.fourth));
        templateModelArrayList.add(new TemplateModel("Fifth", R.drawable.fifth));
        templateModelArrayList.add(new TemplateModel("Sixth", R.drawable.sixth));


        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        templateRv.setLayoutManager(layoutManager);
        templateAdapter = new TemplateAdapter(AllTemplateActivity.this, templateModelArrayList);
        templateRv.setAdapter(templateAdapter);




    }
}