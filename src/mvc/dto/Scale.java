package mvc.dto;


import java.io.Serializable;

public class Scale implements Serializable {
  private String name;
  private int weight;
  private String password;

  public Scale() {
  }

  public Scale(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public Scale(int weight , String password){
    this.weight = weight;
    this.password = password;
  }

  public Scale(String name, int weight, String password) {
    this.name = name;
    this.weight = weight;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Scale{");
    sb.append("name='").append(name).append('\'');
    sb.append(", weight=").append(weight);
    sb.append(", password=").append(password);
    sb.append('}');
    return sb.toString();
  }
}
