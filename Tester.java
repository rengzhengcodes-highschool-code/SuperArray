public class Tester {

  public static void main(String[] args) {
    System.out.println("SuperArray Tester");
    boolean failure = false;
    failure = constructorTester() || failure;
    failure = addAndGetAndSizeTester() || failure;

    System.out.println("\n ~~~ Overall Result ~~~");
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

  private static void methodMessage(String method, boolean failure) {
    if (failure) {
      System.out.println("\nAt least one test case failed for " + method);
    } else {
      System.out.println(method + " PASSED");
    }
  }

  public static boolean constructorTester() {
    System.out.println("\n ~~~ constructor TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    if (test.size() == 0) {
      //passMessage(0);
    } else {
      failure = true;
      errorMessage(0, "" + 0, "" + test.size());
    }

    methodMessage("constructorTester()", failure);
    return failure;
  }

  public static boolean addAndGetAndSizeTester() {
    System.out.println("\n ~~~ add() AND get() AND size() TESTER ~~~");
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
      int expectedSize = index + 1;
      if (test.size() == expectedSize) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, "" + (expectedSize), "" + test.size());
      }
    }
    methodMessage("add() and size() testing", failure);


    System.out.println("\nget() Portion of Testing");
    boolean failureForGet = false;
    for (int index = 0; index < elementsToAdd.length; index++) {
      String expectedGet = elementsToAdd[index];
      if (test.get(index).equals(expectedGet)) {
        //passMessage(index);
      } else {
        failureForGet = true;
        errorMessage(index, expectedGet, test.get(index));
      }
    }
    methodMessage("get()", failureForGet);

    failure = failure || failureForGet;
    methodMessage("\naddAndGetAndSizeTester()", failure);
    return failure;
  }

}
