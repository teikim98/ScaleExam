package mvc.controller;

import mvc.dto.Scale;
import mvc.exception.FileNotFoundException;
import mvc.exception.PasswordWrongException;
import mvc.service.ScaleService;
import mvc.service.ScaleServiceImpl;

public class ScaleController {
  private ScaleService service = new ScaleServiceImpl();

  public void insert(Scale scale){
    try {
      service.insert(scale);
    }catch (Exception e){
      e.getMessage();
    }
  }

  public Scale searchByName(Scale scale) {
    try {
      return service.searchByName(scale);
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      return null; // 예외 발생 시 null 반환
    } catch (PasswordWrongException e) {
      System.out.println(e.getMessage());
      return null; // 예외 발생 시 null 반환
    }
  }


  public void updateScale(Scale scale){
    service.updateScale(scale);
  }
  public void updatePassword(Scale scale){
    service.updatePassword(scale);
  }


}
