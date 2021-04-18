package ba.enox.codebase.patterns.creational.factory.samsung;

import ba.enox.codebase.patterns.creational.factory.Mobile;

public class SamsungS11 implements Mobile {

  protected SamsungS11(String neededConstructionStuffs) {
    System.out.println(
        "Make Samsung S11 with following needed construction stuffs :" + neededConstructionStuffs);
  }

  @Override
  public void doCal(String number) {
    System.out.println("Samsung S11 do CAL :" + number);
  }

  @Override
  public void doSms(String number) {
    System.out.println("Samsung S11 do SMS to :" + number);
  }
}
