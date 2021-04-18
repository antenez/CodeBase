package ba.enox.codebase.patterns.creational.factory.samsung;

import ba.enox.codebase.patterns.creational.factory.Mobile;
import org.junit.Assert;
import org.junit.Test;


public class SamsungFactoryTest {

  @Test
  public void samsungFactoryTest() {

    Mobile s10 = SamsungFactory.makeSamsung(SamsungModel.S10);
    Mobile s11 = SamsungFactory.makeSamsung(SamsungModel.S11);

    Assert.assertTrue(s10.getClass().equals(SamsungS10.class));
    Assert.assertTrue(s11.getClass().equals(SamsungS11.class));

    s10.doCal("012345");
    s11.doCal("012345");

  }

}
