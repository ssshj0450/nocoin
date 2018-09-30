package com.example.user.a0911_2;

public class EventData {
    private String CodeName;
    private String Title;
    private String Date;
    private String Place;
    private String IsFree;
    private String Origin;
    private String Image;

    public EventData(){}

    public EventData(String codename,String title, String date, String place, String isfree, String origin, String image){
        this.CodeName = codename;
        this.Title = title;
        this.Date = date;
        this.Place = place;
        this.IsFree = isfree;
        this.Origin = origin;
        this.Image = image;
    }

    public String getCodeName(){return this.CodeName;}
    public String getTitle(){
        return this.Title;
    }
    public String getDate()
    {
        return this.Date;
    }
    public String getPlace(){
        return this.Place;
    }
    public String getIsFree(){
        return this.IsFree;
    }
    public String getOrigin(){
        return this.Origin;
    }
    public String getImage(){
        return this.Image;
    }

    public void setCodeName(String codeName){this.CodeName=codeName;}
    public void setTitle(String title){
        this.Title = title;
    }
    public void setDate(String date){
        this.Date = date;
    }
    public void setPlace(String place){
        this.Place=place;
    }
    public void setIsFree(String isfree){
        this.IsFree=isfree;
    }
    public void setOrigin(String origin){
        this.Origin=origin;
    }
    public void setImage(String image){
        this.Image=image;
    }
}

