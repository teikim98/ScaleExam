package mvc.service;

import mvc.dto.Scale;

public interface ScaleService {

  public void insert(Scale scale);
  public int searchByName(Scale scale);
  public void updateScale(Scale scale);
  public void updatePassword(Scale scale);



}
