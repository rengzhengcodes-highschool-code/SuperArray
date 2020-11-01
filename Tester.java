public class Tester {

  public static void main(String[] args) {
    System.out.println("SuperArray Tester");
    boolean failure = false;
    failure = constructorTester() || failure;
  }

  private static void passMessage (int testCase) {
    System.out.println("Test case " + testCase + " passed.");
  }

  private static void errorMessage(String expected, String actual) {
    System.out.println("WE HAVE FAILED");
    System.out.println("EXPECTED: " + expected);
    System.out.println("ACTUAL: " + actual);
  }

  public static boolean constructorTester() {
    System.out.println("\n ~~~ constructor TESTER ~~~");

    boolean failure = false;
    SuperArray test = new SuperArray();
    if (test.size() == 10) {
      passMessage(0);
    } else {
      errorMessage("" + 10, "" + test.size());
    }

    if (failure) {
      System.out.println("\nAt least one test case failed for constructorTester()");
    } else {
      System.out.println("constructorTester() PASSED");
    }
    return failure;
  }

}
