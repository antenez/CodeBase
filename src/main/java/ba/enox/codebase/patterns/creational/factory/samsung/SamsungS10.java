package ba.enox.codebase.patterns.creational.factory.samsung;

import ba.enox.codebase.patterns.creational.factory.Mobile;

public class SamsungS10 implements Mobile {

  protected SamsungS10(String neededConstructionStuffs) {
    System.out.println(
        "Make Samsung S10 with following needed construction stuffs :" + neededConstructionStuffs);
  }

  @Override
  public void doCal(String number) {
    System.out.println("Samsung S10 do CAL :" + number);
  }

  @Override
  public void doSms(String number) {
    System.out.println("Samsung S10 do SMS to :" + number);
  }
}
