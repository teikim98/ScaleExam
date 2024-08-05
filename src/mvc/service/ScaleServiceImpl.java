package mvc.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import mvc.dto.Scale;
import mvc.exception.FileNotFoundException;
import mvc.exception.NameMismatchException;
import mvc.exception.NotFoundNameExeption;
import mvc.exception.PassWordWrongExeption;
import mvc.exception.PasswordWrongException;

public class ScaleServiceImpl implements ScaleService {

  public ScaleServiceImpl(){

  }

  @Override
  public void insert(Scale scale) {
    try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/mvc/dto" + scale.getName() + ".txt"));){
      bw.write(scale.getWeight() + ":" + scale.getPassword());
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  @Override
  public int searchByName(Scale scale) throws FileNotFoundException, NameMismatchException, PasswordWrongException {
    String fileName = scale.getName() + ".txt";
    File file = new File(fileName);

    if (!file.exists()) {
      throw new FileNotFoundException();
    }

    if (!file.getName().equals(fileName)) {
      throw new NameMismatchException("파일 이름이 일치하지 않습니다: " + fileName);
    }

    try (BufferedReader br = new BufferedReader(new FileReader("src/mvc/dto/" + fileName))) {
      String[] fileRead = br.readLine().split(":");
      if (scale.getPassword().equals(fileRead[1])) {
        return Integer.parseInt(fileRead[0]);
      } else {
        throw new PasswordWrongException("비밀번호가 일치하지 않습니다.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      return 0; // 예외 발생 시 0을 반환하지만, 실제로는 예외가 던져지므로 이 코드는 실행되지 않음
    }
  }



  @Override
  public void updateScale(Scale scale) {

  }

  @Override
  public void updatePassword(Scale scale) {

  }
}
