package mvc.controller;

import mvc.dto.Scale;
import mvc.service.ScaleService;
import mvc.service.ScaleServiceImpl;

public class ScaleController {
  private ScaleService service = new ScaleServiceImpl();

  public void insert(Scale scale){
    service.insert(scale);
  }

  public int searchByName(Scale scale){
    return service.searchByName(scale);
  }

  public void updateScale(Scale scale){

  }
  public void updatePassword(Scale scale){

  }


}
