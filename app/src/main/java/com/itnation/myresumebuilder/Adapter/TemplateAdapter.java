package com.itnation.myresumebuilder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itnation.myresumebuilder.Model.TemplateModel;
import com.itnation.myresumebuilder.R;
import com.itnation.myresumebuilder.Activity.ResumeDataInputActivity;

import java.util.ArrayList;

public class TemplateAdapter extends RecyclerView.Adapter<TemplateAdapter.ViewHolder> {

    Context context;
    ArrayList<TemplateModel> templateModelArrayList;

    public TemplateAdapter(Context context, ArrayList<TemplateModel> templateModelArrayList) {
        this.context = context;
        this.templateModelArrayList = templateModelArrayList;
    }

    @NonNull
    @Override
    public TemplateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.template_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateAdapter.ViewHolder holder, int position) {

        TemplateModel templateModel = templateModelArrayList.get(position);

        holder.templateImg.setImageResource(templateModel.getTemplate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ResumeDataInputActivity.class);
                intent.putExtra("templateName",templateModel.getTemplateName());
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return templateModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView templateImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            templateImg = itemView.findViewById(R.id.templateImg);
        }
    }
}
