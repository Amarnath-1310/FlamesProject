package com.flames.model;

public class FlamesRequest {
  private String male;
  private String female;

  public FlamesRequest() {
  }

  public FlamesRequest(String male, String female) {
    this.male = male;
    this.female = female;
  }

  public String getMale() {
    return male;
  }

  public void setMale(String male) {
    this.male = male;
  }

  public String getFemale() {
    return female;
  }

  public void setFemale(String female) {
    this.female = female;
  }
}