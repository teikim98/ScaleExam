package mvc.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import mvc.dto.Scale;
import mvc.exception.FileNotFoundException;
import mvc.exception.PasswordWrongException;

public class ScaleServiceImpl implements ScaleService {

  public ScaleServiceImpl(){

  }

  @Override
  public void insert(Scale scale) {
    try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/mvc/dto/" + scale.getName() + ".txt"));){
      bw.write(scale.getWeight() + ":" + scale.getPassword());
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  @Override
  public Scale searchByName(Scale scale) throws FileNotFoundException, PasswordWrongException {
    String fileName = "src/mvc/dto/" + scale.getName() + ".txt";
    File file = new File(fileName);

    if (!file.exists()) {
      throw new FileNotFoundException("이름을 찾을 수 없습니다: " + scale.getName());
    }

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String[] fileRead = br.readLine().split(":");
      if (scale.getPassword().equals(fileRead[1])) {
        return new Scale(scale.getName(), Integer.parseInt(fileRead[0]), fileRead[1]);
      } else {
        throw new PasswordWrongException("비밀번호가 일치하지 않습니다.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null; // 예외 발생 시 null 반환
    }
  }




  @Override
  public void updateScale(Scale scale){
    try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/mvc/dto/" + scale.getName() + ".txt"));){
      bw.write(scale.getWeight() + ":" + scale.getPassword());
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  @Override
  public void updatePassword(Scale scale) {
    String fileName = "src/mvc/dto/" + scale.getName() + ".txt";
    File file = new File(fileName);
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String[] fileRead = br.readLine().split(":");
        Scale scale1 = new Scale(scale.getName(), Integer.parseInt(fileRead[0]),scale.getPassword());
        System.out.printf(scale.getPassword());
        this.updateScale(scale1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
