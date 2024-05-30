package com.itnation.myresumebuilder.Model;

import android.graphics.Bitmap;

public class TemplateModel {

    String TemplateName;
    int template;

    public TemplateModel(String templateName, int template) {
        TemplateName = templateName;
        this.template = template;
    }

    public TemplateModel() {
    }

    public String getTemplateName() {
        return TemplateName;
    }

    public void setTemplateName(String templateName) {
        TemplateName = templateName;
    }

    public int getTemplate() {
        return template;
    }

    public void setTemplate(int template) {
        this.template = template;
    }
}
