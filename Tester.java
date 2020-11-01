public class Tester {

  public static void main(String[] args) {
    System.out.println("SuperArray Tester");
    boolean failure = false;
    failure = constructorTester() || failure;
    failure = addAndGetAndSizeTester() || failure;

    if (failure) {
      System.out.println("Is that blue smoke?");
    } else {
      System.out.println("All's good in the neighborhood");
    }
  }

  private static void passMessage (int testCase) {
    System.out.println("Test case " + testCase + " passed.");
  }

  private static void errorMessage(int testCase, String expected, String actual) {
    System.out.println("WE HAVE FAILED AT TEST CASE " + testCase);
    System.out.println("EXPECTED: " + expected);
    System.out.println("ACTUAL: " + actual);
  }

  public static boolean constructorTester() {
    System.out.println("\n ~~~ constructor TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    if (test.size() == 0) {
      passMessage(0);
    } else {
      errorMessage(0, "" + 0, "" + test.size());
    }

    if (failure) {
      System.out.println("\nAt least one test case failed for constructorTester()");
    } else {
      System.out.println("constructorTester() PASSED");
    }
    return failure;
  }

  public static boolean addAndGetAndSizeTester() {
    System.out.println("\nadd() AND get() AND size() TESTER");
    boolean failure = false;
    SuperArray test = new SuperArray();
    String[] elementsToAdd = {
      "foo",
      "bar",
      "bread"
    };

    System.out.println("add() + size() Portion of Testing");
    for (int index = 0; index < elementsToAdd.length; index++) {
      test.add(elementsToAdd[index]);
      if (test.size() == index + 1) {
        passMessage(index);
      } else {
        errorMessage(index, "" + (index + 1), "" + test.size());
      }
    }

    return failure;
  }

}
