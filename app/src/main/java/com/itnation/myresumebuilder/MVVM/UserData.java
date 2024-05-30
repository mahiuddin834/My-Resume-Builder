package com.itnation.myresumebuilder.MVVM;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_data")
public class UserData {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String fullName;
    private String position;
    private String email;
    private String phone;
    private String website;
    private String address;
    private String aboutMe;
    private String workEx1StartDate;
    private String workEx1EndDate;
    private String workEx1CompanyName;
    private String workEx1Responsibilities;
    private String workEx2StartDate;
    private String workEx2EndDate;
    private String workEx2CompanyName;
    private String workEx2Responsibilities;
    private String workEx3StartDate;
    private String workEx3EndDate;
    private String workEx3CompanyName;
    private String workEx3Responsibilities;
    private String edu1StartDate;
    private String edu1EndDate;
    private String edu1Department;
    private String edu1University;
    private String edu2StartDate;
    private String edu2EndDate;
    private String edu2Department;
    private String edu2University;
    private String expertise1;
    private String expertise2;
    private String expertise3;
    private String expertise4;
    private String expertise5;
    private String expertise6;
    private String language1;
    private String language2;
    private String language3;
    private String language4;
    private String language5;
    private String language6;
    private String ref1Name;
    private String ref1Position;
    private String ref1Company;
    private String ref1Email;
    private String ref1Phone;
    private String ref2Name;
    private String ref2Position;
    private String ref2Company;
    private String ref2Email;
    private String ref2Phone;
    private byte[] profileImage;


    public UserData(int id,String fullName, String position, String email, String phone, String website, String address, String aboutMe, String workEx1StartDate, String workEx1EndDate, String workEx1CompanyName, String workEx1Responsibilities, String workEx2StartDate, String workEx2EndDate, String workEx2CompanyName, String workEx2Responsibilities, String workEx3StartDate, String workEx3EndDate, String workEx3CompanyName, String workEx3Responsibilities, String edu1StartDate, String edu1EndDate, String edu1Department, String edu1University, String edu2StartDate, String edu2EndDate, String edu2Department, String edu2University, String expertise1, String expertise2, String expertise3, String expertise4, String expertise5, String expertise6, String language1, String language2, String language3, String language4, String language5, String language6, String ref1Name, String ref1Position, String ref1Company, String ref1Email, String ref1Phone, String ref2Name, String ref2Position, String ref2Company, String ref2Email, String ref2Phone, byte[] profileImage) {
        this.id=id;
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.aboutMe = aboutMe;
        this.workEx1StartDate = workEx1StartDate;
        this.workEx1EndDate = workEx1EndDate;
        this.workEx1CompanyName = workEx1CompanyName;
        this.workEx1Responsibilities = workEx1Responsibilities;
        this.workEx2StartDate = workEx2StartDate;
        this.workEx2EndDate = workEx2EndDate;
        this.workEx2CompanyName = workEx2CompanyName;
        this.workEx2Responsibilities = workEx2Responsibilities;
        this.workEx3StartDate = workEx3StartDate;
        this.workEx3EndDate = workEx3EndDate;
        this.workEx3CompanyName = workEx3CompanyName;
        this.workEx3Responsibilities = workEx3Responsibilities;
        this.edu1StartDate = edu1StartDate;
        this.edu1EndDate = edu1EndDate;
        this.edu1Department = edu1Department;
        this.edu1University = edu1University;
        this.edu2StartDate = edu2StartDate;
        this.edu2EndDate = edu2EndDate;
        this.edu2Department = edu2Department;
        this.edu2University = edu2University;
        this.expertise1 = expertise1;
        this.expertise2 = expertise2;
        this.expertise3 = expertise3;
        this.expertise4 = expertise4;
        this.expertise5 = expertise5;
        this.expertise6 = expertise6;
        this.language1 = language1;
        this.language2 = language2;
        this.language3 = language3;
        this.language4 = language4;
        this.language5 = language5;
        this.language6 = language6;
        this.ref1Name = ref1Name;
        this.ref1Position = ref1Position;
        this.ref1Company = ref1Company;
        this.ref1Email = ref1Email;
        this.ref1Phone = ref1Phone;
        this.ref2Name = ref2Name;
        this.ref2Position = ref2Position;
        this.ref2Company = ref2Company;
        this.ref2Email = ref2Email;
        this.ref2Phone = ref2Phone;
        this.profileImage = profileImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getWorkEx1StartDate() {
        return workEx1StartDate;
    }

    public void setWorkEx1StartDate(String workEx1StartDate) {
        this.workEx1StartDate = workEx1StartDate;
    }

    public String getWorkEx1EndDate() {
        return workEx1EndDate;
    }

    public void setWorkEx1EndDate(String workEx1EndDate) {
        this.workEx1EndDate = workEx1EndDate;
    }

    public String getWorkEx1CompanyName() {
        return workEx1CompanyName;
    }

    public void setWorkEx1CompanyName(String workEx1CompanyName) {
        this.workEx1CompanyName = workEx1CompanyName;
    }

    public String getWorkEx1Responsibilities() {
        return workEx1Responsibilities;
    }

    public void setWorkEx1Responsibilities(String workEx1Responsibilities) {
        this.workEx1Responsibilities = workEx1Responsibilities;
    }

    public String getWorkEx2StartDate() {
        return workEx2StartDate;
    }

    public void setWorkEx2StartDate(String workEx2StartDate) {
        this.workEx2StartDate = workEx2StartDate;
    }

    public String getWorkEx2EndDate() {
        return workEx2EndDate;
    }

    public void setWorkEx2EndDate(String workEx2EndDate) {
        this.workEx2EndDate = workEx2EndDate;
    }

    public String getWorkEx2CompanyName() {
        return workEx2CompanyName;
    }

    public void setWorkEx2CompanyName(String workEx2CompanyName) {
        this.workEx2CompanyName = workEx2CompanyName;
    }

    public String getWorkEx2Responsibilities() {
        return workEx2Responsibilities;
    }

    public void setWorkEx2Responsibilities(String workEx2Responsibilities) {
        this.workEx2Responsibilities = workEx2Responsibilities;
    }

    public String getWorkEx3StartDate() {
        return workEx3StartDate;
    }

    public void setWorkEx3StartDate(String workEx3StartDate) {
        this.workEx3StartDate = workEx3StartDate;
    }

    public String getWorkEx3EndDate() {
        return workEx3EndDate;
    }

    public void setWorkEx3EndDate(String workEx3EndDate) {
        this.workEx3EndDate = workEx3EndDate;
    }

    public String getWorkEx3CompanyName() {
        return workEx3CompanyName;
    }

    public void setWorkEx3CompanyName(String workEx3CompanyName) {
        this.workEx3CompanyName = workEx3CompanyName;
    }

    public String getWorkEx3Responsibilities() {
        return workEx3Responsibilities;
    }

    public void setWorkEx3Responsibilities(String workEx3Responsibilities) {
        this.workEx3Responsibilities = workEx3Responsibilities;
    }

    public String getEdu1StartDate() {
        return edu1StartDate;
    }

    public void setEdu1StartDate(String edu1StartDate) {
        this.edu1StartDate = edu1StartDate;
    }

    public String getEdu1EndDate() {
        return edu1EndDate;
    }

    public void setEdu1EndDate(String edu1EndDate) {
        this.edu1EndDate = edu1EndDate;
    }

    public String getEdu1Department() {
        return edu1Department;
    }

    public void setEdu1Department(String edu1Department) {
        this.edu1Department = edu1Department;
    }

    public String getEdu1University() {
        return edu1University;
    }

    public void setEdu1University(String edu1University) {
        this.edu1University = edu1University;
    }

    public String getEdu2StartDate() {
        return edu2StartDate;
    }

    public void setEdu2StartDate(String edu2StartDate) {
        this.edu2StartDate = edu2StartDate;
    }

    public String getEdu2EndDate() {
        return edu2EndDate;
    }

    public void setEdu2EndDate(String edu2EndDate) {
        this.edu2EndDate = edu2EndDate;
    }

    public String getEdu2Department() {
        return edu2Department;
    }

    public void setEdu2Department(String edu2Department) {
        this.edu2Department = edu2Department;
    }

    public String getEdu2University() {
        return edu2University;
    }

    public void setEdu2University(String edu2University) {
        this.edu2University = edu2University;
    }

    public String getExpertise1() {
        return expertise1;
    }

    public void setExpertise1(String expertise1) {
        this.expertise1 = expertise1;
    }

    public String getExpertise2() {
        return expertise2;
    }

    public void setExpertise2(String expertise2) {
        this.expertise2 = expertise2;
    }

    public String getExpertise3() {
        return expertise3;
    }

    public void setExpertise3(String expertise3) {
        this.expertise3 = expertise3;
    }

    public String getExpertise4() {
        return expertise4;
    }

    public void setExpertise4(String expertise4) {
        this.expertise4 = expertise4;
    }

    public String getExpertise5() {
        return expertise5;
    }

    public void setExpertise5(String expertise5) {
        this.expertise5 = expertise5;
    }

    public String getExpertise6() {
        return expertise6;
    }

    public void setExpertise6(String expertise6) {
        this.expertise6 = expertise6;
    }

    public String getLanguage1() {
        return language1;
    }

    public void setLanguage1(String language1) {
        this.language1 = language1;
    }

    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    public String getLanguage3() {
        return language3;
    }

    public void setLanguage3(String language3) {
        this.language3 = language3;
    }

    public String getLanguage4() {
        return language4;
    }

    public void setLanguage4(String language4) {
        this.language4 = language4;
    }

    public String getLanguage5() {
        return language5;
    }

    public void setLanguage5(String language5) {
        this.language5 = language5;
    }

    public String getLanguage6() {
        return language6;
    }

    public void setLanguage6(String language6) {
        this.language6 = language6;
    }

    public String getRef1Name() {
        return ref1Name;
    }

    public void setRef1Name(String ref1Name) {
        this.ref1Name = ref1Name;
    }

    public String getRef1Position() {
        return ref1Position;
    }

    public void setRef1Position(String ref1Position) {
        this.ref1Position = ref1Position;
    }

    public String getRef1Company() {
        return ref1Company;
    }

    public void setRef1Company(String ref1Company) {
        this.ref1Company = ref1Company;
    }

    public String getRef1Email() {
        return ref1Email;
    }

    public void setRef1Email(String ref1Email) {
        this.ref1Email = ref1Email;
    }

    public String getRef1Phone() {
        return ref1Phone;
    }

    public void setRef1Phone(String ref1Phone) {
        this.ref1Phone = ref1Phone;
    }

    public String getRef2Name() {
        return ref2Name;
    }

    public void setRef2Name(String ref2Name) {
        this.ref2Name = ref2Name;
    }

    public String getRef2Position() {
        return ref2Position;
    }

    public void setRef2Position(String ref2Position) {
        this.ref2Position = ref2Position;
    }

    public String getRef2Company() {
        return ref2Company;
    }

    public void setRef2Company(String ref2Company) {
        this.ref2Company = ref2Company;
    }

    public String getRef2Email() {
        return ref2Email;
    }

    public void setRef2Email(String ref2Email) {
        this.ref2Email = ref2Email;
    }

    public String getRef2Phone() {
        return ref2Phone;
    }

    public void setRef2Phone(String ref2Phone) {
        this.ref2Phone = ref2Phone;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }
}
