package mvc.service;

import mvc.dto.Scale;
import mvc.exception.FileNotFoundException;
import mvc.exception.PasswordWrongException;

public interface ScaleService {

  public void insert(Scale scale);
  public Scale searchByName(Scale scale) throws FileNotFoundException  , PasswordWrongException;
  public void updateScale(Scale scale);
  public void updatePassword(Scale scale);



}
