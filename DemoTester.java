import java.util.Arrays;

public class DemoTester {

  public static void main(String[] args) {
    findOverlapTester();
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

  private static void testerMessage(String method) {
    System.out.println("\n ~~~ " + method + " TESTER ~~~");
  }

  public static boolean findOverlapTester() {
    testerMessage("findOverlap()");
    boolean failure = false;

    String[] aElements = {
      "9","1","2","2","3","4"
    };
    String[] bElements = {
      "0","4","2","2","9"
    };
    SuperArray a = new SuperArray();
    SuperArray b = new SuperArray();

    SuperArray output = Demo.findOverlap(a, b);
    String[] expectedArray = {};
    if (Arrays.equals(output.toArray(), expectedArray)) {
      passMessage(0);
    } else {
      failure = true;
      errorMessage(1, expectedArray.toString(), output.toArray().toString());
    }

    for (String element : aElements) {
      a.add(element);
    }
    for (String element : bElements) {
      b.add(element);
    }

    output = Demo.findOverlap(a, b);
    String[] expectedArray1 = {"9","2","4"};
    if (Arrays.equals(output.toArray(), expectedArray1)) {
      passMessage(1);
    } else {
      failure = true;
      errorMessage(1, expectedArray1.toString(), output.toArray().toString());
    }

    return failure;
  }

}
