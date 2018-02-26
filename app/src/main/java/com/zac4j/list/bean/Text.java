package com.zac4j.list.bean;

/**
 * Bean for text display
 * Created by Zaccc on 2018/2/26.
 */

public class Text {
  private String title;
  private String content;

  public Text(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
