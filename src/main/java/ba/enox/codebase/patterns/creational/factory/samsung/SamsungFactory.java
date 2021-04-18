package ba.enox.codebase.patterns.creational.factory.samsung;

import ba.enox.codebase.patterns.creational.factory.Mobile;

public class SamsungFactory {

  public static Mobile makeSamsung(SamsungModel samsungModel) {
    switch (samsungModel) {
      case S10:
        {
          return new SamsungS10("S10 CPU 2Core 2.5GHZ RAN4 GB, screen ....");
        }
      case S11:
        {
          return new SamsungS11("S11 CPU 4Core 2.5GHZ RAN8 GB , screen ....");
        }
      default:
        return null;
    }
  }
}
