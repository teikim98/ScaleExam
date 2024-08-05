package mvc.view;

import java.util.Scanner;
import mvc.controller.ScaleController;
import mvc.dto.Scale;

public class MenuView {

  Scanner sc= new Scanner(System.in); // 전역변수 초기화, 생성자 호출
  ScaleController controller = new ScaleController();
  /**
   전체 메뉴를 출력하는 메소드
   */
  public void printMenu(){

    while(true){

      System.out.println("----------------------------------------------------------------------------------");
      System.out.println("1. 몸무게 입력    2. 몸무게 검색     3.몸무게 변경     4. 비밀번호 변경  5. 종료");
      System.out.println("----------------------------------------------------------------------------------");
      System.out.print("메뉴선택 > ");


      String  menu = sc.nextLine();
      switch(menu){
        case "1" :
            inputInsert();;
          break;
        case "2" :
            searchByName();
          break;
        case "3" :
            updateScale();
          break;
        case "4" :
            updatePassWord();
          break;
        case "5" :
          System.exit(0);
        default:
                  System.out.println("메뉴를 다시 선택해주세요!!!!");

      }//switch문끝

    }//while문끝
  }//메소드끝

  public void inputInsert(){
    System.out.println("이름을 입력하여 주십시요.");
    System.out.print("이름 : ");
    String name = sc.nextLine();
    System.out.println("몸무게를 입력하여 주십시요.");
    System.out.print("몸무게 : ");
    int weight = Integer.parseInt(sc.nextLine());
    System.out.println("비밀번호를 입력하여 주십시요.");
    System.out.print("비밀번호 : ");
    String passWord = sc.nextLine();

    controller.insert(new Scale(name,weight,passWord));

  }

  public  void searchByName(){
    int count = 0;

      System.out.println("검색할 이름을 입력하여 주십시요.");
    System.out.print("이름 : ");
    String name = sc.nextLine();
    while (count < 3){
      System.out.println("비밀번호를 입력하여 주십시요.");
      System.out.print("비밀번호 : ");
      String passWord = sc.nextLine();
      controller.searchByName(new Scale(name,passWord));
      count++;
    }


  }

  public  void updateScale() {
    System.out.println("검색할 이름을 입력하여 주십시요.");
    System.out.print("이름 : ");
    String name = sc.nextLine();
    System.out.println("비밀번호를 입력하여 주십시요.");
    System.out.print("비밀번호 : ");
    String passWord = sc.nextLine();
    controller.searchByName(new Scale(name,passWord));

    System.out.println("변경할 몸무게를 입력해주세요");
    System.out.print("몸무게 : ");
    int weight = Integer.parseInt(sc.nextLine());

    controller.updateScale(new Scale(name , weight , passWord));

  }

  public void updatePassWord(){
    System.out.println("비밀번호를 변경할 이름을 입력하여 주십시요.");
    System.out.print("이름 : ");
    String name = sc.nextLine();
    System.out.println("비밀번호를 입력하여 주십시요.");
    System.out.print("비밀번호 : ");
    String passWord = sc.nextLine();

    controller.updatePassword(new Scale(name , passWord));

  }

}
