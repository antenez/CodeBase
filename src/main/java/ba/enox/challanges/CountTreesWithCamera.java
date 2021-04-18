package ba.enox.challanges;

import java.util.Map;
import java.util.TreeMap;
import org.junit.Assert;

/**
 * Assumptions: Task is not well defined and I assume that it is about camera angle and trees
 * coordinates. And I am trying to find beginning of camera view degree which will film highest
 * number of trees.
 *
 * <p>Resources: Coordinates to distance:
 * https://stackoverflow.com/questions/15994194/how-to-convert-x-y-coordinates-to-an-angle Sliding
 * window: https://stackoverflow.com/questions/8269916/what-is-sliding-window-algorithm-examples
 */
public class CountTreesWithCamera {

  public static void main(String[] args) {
    //    We consider that camera is 0, 0 coordinate (can be distance as well in meters)
    testCoordinates();

    int cameraDegree = 45;
    TreeMap<Integer, Integer> treeAngles = getPrepareTestCoordinatesTreeMap();

    TreeMap<Integer, Integer> newCircle = new TreeMap<>();
    // To support edge case we need two circles, 360 + angle of camera.
    for (Integer key : treeAngles.keySet()) {
      newCircle.put(2 * key, treeAngles.get(key));
    }
    treeAngles.putAll(newCircle);
    System.out.println(treeAngles);

    int beginOfHighestRange = 0, currentFrameCount = 0;
    int highestRangeCount;

    /*Helper frames to track counts*/
    TreeMap<Integer, Integer> frames = new TreeMap<>();
    // Initial angle frame
    for (int i = 0; i <= cameraDegree; i++) {
      if (treeAngles.containsKey(i)) {
        currentFrameCount += treeAngles.get(i);
      }
    }

    frames.put(0, currentFrameCount);
    highestRangeCount = currentFrameCount;

    for (int i = cameraDegree + 1; i <= 360 + cameraDegree; i++) {
      int toRemoveValue = 0, toAddValue = 0;
      int toRemoveIndex = i - cameraDegree - 1;

      if (treeAngles.containsKey(toRemoveIndex)) {
        toRemoveValue = treeAngles.get(toRemoveIndex);
      }
      if (treeAngles.containsKey(i)) {
        toAddValue = treeAngles.get(i);
      }

      currentFrameCount = currentFrameCount - toRemoveValue + toAddValue;
      frames.put(i - cameraDegree, currentFrameCount);

      if (currentFrameCount > highestRangeCount) {
        highestRangeCount = currentFrameCount;
        beginOfHighestRange = i - cameraDegree;
      }
    }

    System.out.println("HighestRangeCount : " + highestRangeCount);
    System.out.println("BeginAngle : " + beginOfHighestRange);
    Assert.assertEquals(207, beginOfHighestRange);
    Assert.assertEquals(45, cameraDegree);
    System.out.println("Frames " + frames);
  }

  /*
   * 1st quadrant => 3
   * 45 ,3
   *
   * 2nt quadrant => 5
   * 125 ,4
   * 125 ,1
   *
   * 3rd quadrant => 9
   * 225 ,3
   * 226 ,6
   *
   * 4th quadrant => 3
   * 315 ,2
   * 316 ,1
   * */
  private static TreeMap<Integer, Integer> getPrepareTestCoordinatesTreeMap() {
    TreeMap<Integer, Integer> treeAngles = new TreeMap<>();
    treeAngles.putAll(Map.of(45, 3, 125, 4, 126, 1, 225, 3, 226, 6, 315, 2, 316, 1));
    return treeAngles;
  }

  private static void testCoordinates() {
    Assert.assertEquals(45, getAngleRelative(0, 15, 0, 15), 0);
    Assert.assertEquals(135, getAngleRelative(0, -15, 0, 15), 0);
    Assert.assertEquals(-135, getAngleRelative(0, -15, 0, -15), 0);
    Assert.assertEquals(-45, getAngleRelative(0, 15, 0, -15), 0);

    Assert.assertEquals(45, getAngleAbsolute(0, 15, 0, 15), 0);
    Assert.assertEquals(135, getAngleAbsolute(0, -15, 0, 15), 0);
    Assert.assertEquals(225, getAngleAbsolute(0, -15, 0, -15), 0);
    Assert.assertEquals(315, getAngleAbsolute(0, 15, 0, -15), 0);
  }

  public static double getAngleAbsolute(int x1, int x2, int y1, int y2) {
    double angle = getAngle(getRadians(x1, x2, y1, y2));
    if (angle < 0) {
      return 360 + (angle);
    }
    return angle;
  }

  public static double getAngleRelative(int x1, int x2, int y1, int y2) {
    double angle = getAngle(getRadians(x1, x2, y1, y2));
    return angle;
  }

  private static double getRadians(int x1, int x2, int y1, int y2) {
    int deltaX = x2 - x1;
    int deltaY = y2 - y1;
    double rad = Math.atan2(deltaY, deltaX); // In radians
    return rad;
  }

  /**
   * @param radian
   * @return relative angle range -180, 180
   */
  private static double getAngle(double radian) {
    return radian * (180 / Math.PI);
  }
}
