package ba.enox.challanges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** A B U Z A C ... Find all the paths from A to Z. */
public class FindListOfPaths {

  private static HashMap<String, Set<String>> lookup = new HashMap<>();

  /**
   * A - B - Y - R - Q - Z
   *
   * <p>A - B - Y - U - Z
   *
   * <p>A - C - R - Q - Z
   *
   * <p>A - Q - Z
   *
   * <p>A - B - Y - U - K - Z
   */
  private static List<String> pairs =
      List.of(
          "A B", "U Z", "B A", "A C", "Z A", "K Z", "A Q", "D A", "U K", "P U", "U P", "B Y", "Y R",
          "Y U", "C R", "R Q", "A D", "Q Z");

  public static void main(String[] args) {
    System.out.println("+++source       test  " + getSource(pairs.get(0)));
    System.out.println("+++destination  test  " + getDestination(pairs.get(0)));

    Iterator<String> it = pairs.iterator();
    while (it.hasNext()) {
      String s = it.next();
      String start = FindListOfPaths.getSource(s);
      String destination = FindListOfPaths.getDestination(s);

      if (!lookup.containsKey(start)) {
        HashSet<String> adjecents = new HashSet<>();
        adjecents.add(destination);
        lookup.put(start, adjecents);
      } else {
        lookup.get(start).add(destination);
      }
    }
    System.out.println(lookup);

    List<List<String>> paths = breeadFirstsearch(lookup, "A", "Z");
    for (List<String> path : paths) {
      System.out.println("Path : " + path);
    }

    // Search from A start  to Z destionation
  }

  private static List<List<String>> breeadFirstsearch(
      HashMap<String, Set<String>> nodes, String source, String destination) {
    List<List<String>> resultPaths = new ArrayList<>();
    Queue<List<String>> pathsToCheck = new LinkedList<>();
    pathsToCheck.add(List.of(source));

    Set<String> visited = new HashSet<>();

    while (!pathsToCheck.isEmpty()) {
      List<String> currentPathToCheck = pathsToCheck.poll();

      if (currentPathToCheck.get(currentPathToCheck.size() - 1).equals(destination)) {
        resultPaths.add(new ArrayList<>(currentPathToCheck));
      } else {
        String lastDestination = currentPathToCheck.get(currentPathToCheck.size() - 1);

        Set<String> adjecents = nodes.get(lastDestination);
        if (adjecents == null) {
          continue;
        }
        for (String adjecent : adjecents) {
          ArrayList<String> newList = new ArrayList<>(currentPathToCheck);
          newList.add(adjecent);
          //TODO check how to brek loops in this task. If it would be non cyclic then it would be fine.
//          if (visited.contains(newList.toString())) {
//            continue;
//          } else {
            visited.add(newList.toString());
            pathsToCheck.add(newList);
//          }
        }
      }
    }

    return resultPaths;
  }

  private static String getSource(String s) {
    return s.substring(0, s.indexOf(" "));
  }

  private static String getDestination(String s) {
    return s.substring(s.indexOf(" ") + 1);
  }
}

class Node {
  String name;
  Set<Node> adjecents;

  public Node(String start) {
    this.name = start;
    this.adjecents = new HashSet<>();
  }

  public String getName() {
    return this.name;
  }

  public void addAdjecent(Node adjecent) {
    this.adjecents.add(adjecent);
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == this) return true;
    if (!(obj instanceof Node)) {
      return false;
    }

    Node node = (Node) obj;
    return this.name.equals(node.getName());
  }

  @Override
  public int hashCode() {
    return this.name.hashCode();
  }
}
