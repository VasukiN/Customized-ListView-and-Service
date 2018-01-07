package com.example.vasuki.customlistviewproject;

/**
 * Created by Vasuki on 12/2/2017.
 */

public class DataModel {
    String name;
    String type;
    String version_number;
    String feature;
    public DataModel(String name,String type,String version_Number,String feature)
    {
        this.name=name;
        this.type=type;
        this.version_number=version_Number;
        this.feature=feature;


    }
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String getVersion_number()
    {
        return version_number;
    }
    public String feature()
    {
        return feature;
    }
}

