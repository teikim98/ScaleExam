package mvc.view;

import mvc.dto.Scale;

public class SuccessView {

  public static void printScale(Scale scale){
    System.out.println("*************************************************");
    System.out.println("현재 " + scale.getName() + "몸무게는 " + scale.getWeight() + "입니다");
    System.out.println("*************************************************");
  }

  public static void printMessage(String message){
    System.out.println(message + "\n");
  }

}
