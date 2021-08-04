package KRISS;

public class Pragraph {
  private int index;
  private String paragraph;
  private int attribute_abstract;
  private int attribute_intro;
  private int attribute_main;
  private int attribute_method;
  private int attribute_summary;
  private int attribute_caption;

  public int getPragraph() {
    return this.index;
  }

  public void setPragraph(String x) {
    this.index = this.index++;
    this.attribute_abstract = 0;
    this.attribute_intro = 0;
    this.attribute_main = 0;
    this.attribute_method = 0;
    this.attribute_summary = 0;
    this.attribute_caption = 0;
    switch (x) {
      case "abstract" -> this.attribute_abstract = 1;
      case "intro" -> this.attribute_intro = 1;
      case "main" -> this.attribute_main = 1;
      case "method" -> this.attribute_method = 1;
      case "summary" -> this.attribute_summary = 1;
      case "caption" -> this.attribute_caption = 1;
    }
  }
}
