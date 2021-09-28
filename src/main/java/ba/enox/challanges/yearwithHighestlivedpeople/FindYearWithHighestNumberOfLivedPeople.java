package ba.enox.challanges.yearwithHighestlivedpeople;

public class FindYearWithHighestNumberOfLivedPeople {
  public static void main(String[] args) {
    System.out.println(getYearWithMostLivedPersons(getTestData()));

  }

  /**
   * --------1990(1)----------------------------2015(-1)
   * --------1990(1)-1995(1)--------------------2015(-1)-2020(-1)
   * 1980(1)-1990(1)-1995(1)-----------2010(-1)-2015(-1)-2020(-1)
   * 1980(1)-1990(1)-1995(1)-----------2010(0)-2015(-1)-2020(-2) .... give deltas for every year
   * (y1)= 20 totals 20                                               .
   * (y2)= 10 30                                                      .
   * (y3)= -2 28                                                      .
   * (y4)= 5 32                                                       .
   * (y5)= 12 44                                                      .
   * (y6)= -8 36                                                      .
   */

  //TODO fix algorithm to consider -1 in next year after death year because you can not be little bit live in one year
  public static int getYearWithMostLivedPersons(Person[] persons) {
    int minYear =  minYear(persons);
    int maxYear =  maxYear(persons);
    int[] deltas =  getLivingPersonsPerYerDelta(persons, minYear, maxYear);

    int maxIndex=0;
    int totalPersons=0;
    int maxTotalPersonsCount = 0;
    for(int index=0; index < deltas.length;index++){
      int currentDelta = deltas[index];
      totalPersons += currentDelta;
      if(totalPersons>maxTotalPersonsCount){
        maxTotalPersonsCount = totalPersons;
        maxIndex = index;
      }
    }
    System.out.println("max index"+maxIndex);
    System.out.println("max total"+maxTotalPersonsCount);

    System.out.println("response year "+(maxIndex+minYear));

    return maxIndex+minYear;
  }

  private static int[] getLivingPersonsPerYerDelta(Person[] persons , int minYear, int maxYear){

    int[] deltas= new int[(maxYear-minYear)+1];

    for (Person p : persons) {
      deltas[p.getBirthYear()-minYear]+=1;
      deltas[p.getDeathYear()-minYear]-=1;
    }
    return deltas;
  }

  private static int minYear(Person[] persons) {
    /** Handle exception when empty or null */
    int min = persons[0].getBirthYear();
    for (Person p : persons) {
      if (min > p.getBirthYear()) {
        min = p.getBirthYear();
      }
    }
    return min;
  }

  private static int maxYear(Person[] persons) {
    /** Handle exception when empty or null */
    int max = persons[0].getDeathYear();
    for (Person p : persons) {
      if (max < p.getDeathYear()) {
        max = p.getDeathYear();
      }
    }
    return max;
  }

  private static Person[] getTestData() {
    Person[] persons =
        new Person[] {
          new Person(1990, 2015),
          new Person(1995, 2020),
          new Person(1980, 2010),
          new Person(2010, 2020),
          new Person(1990, 2010),
          new Person(1995, 2015),
          new Person(1990, 2020)
        };
    return persons;
  }
}

class Person {

  private int birthYear;
  private int deathYear;

  public Person(int birthYear, int deathYear) {
    this.birthYear = birthYear;
    this.deathYear = deathYear;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public int getDeathYear() {
    return deathYear;
  }
}
