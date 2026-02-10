package com.flames.model;

public class FlamesResponse {
  private String result;
  private String meaning;
  private String image;

  public FlamesResponse() {
  }

  public FlamesResponse(String result, String meaning, String image) {
    this.result = result;
    this.meaning = meaning;
    this.image = image;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getMeaning() {
    return meaning;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}