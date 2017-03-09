package com.example.miller.alyalefigaro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subcategory {

@SerializedName("id")
@Expose
private String id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("ranking")
@Expose
private Integer ranking;
@SerializedName("isVisible")
@Expose
private Boolean isVisible;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getRanking() {
return ranking;
}

public void setRanking(Integer ranking) {
this.ranking = ranking;
}

public Boolean getIsVisible() {
return isVisible;
}

public void setIsVisible(Boolean isVisible) {
this.isVisible = isVisible;
}

}


