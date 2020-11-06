import java.util.Arrays;

public class DemoTester {

  public static void main(String[] args) {
    boolean failure = false;

    failure = findOverlapTester() || failure;
    failure = zipTester() || failure;

    System.out.println("\n ~~~ Overall Result ~~~");
    if (failure) {
      System.out.println("Is that blue smoke?");
    } else {
      System.out.println("All's good in the neighbourhood");
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
      errorMessage(0, expectedArray.toString(), output.toArray().toString());
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

    methodMessage("findOverlap", failure);
    return failure;
  }

  public static boolean zipTester() {
    testerMessage("zip()");
    boolean failure = false;
    String[] elementsA = {
      "a","b","c","d","e","f"
    };
    String[] elementsB = {
      "0","1","2","3"
    };
    String[] expectedOutputArray = {
      "a","0","b","1","c","2","d","3","e","f"
    };

    SuperArray a = new SuperArray();
    SuperArray b = new SuperArray();
    SuperArray c = new SuperArray();
    for (int index = 0; index < elementsA.length; index++) {
      a.add(elementsA[index]);
    }
    for (int index = 0; index < elementsB.length; index++) {
      b.add(elementsB[index]);
    }
    for (int index = 0; index < expectedOutputArray.length; index++) {
      c.add(expectedOutputArray[index]);
    }

    if (c.equals(Demo.zip(a, b))) {
      passMessage(0);
    } else {
      failure = true;
      errorMessage(0, c.toString(), Demo.zip(a, b).toString());
    }

    String[] elementsA1 = {
      "a","b","c"
    };
    String[] elementsB1 = {
      "0","1","2","3","4"
    };
    String[] expectedOutputArray1 = {
      "a","0","b","1","c","2","3","4"
    };
    a.clear();
    b.clear();
    c.clear();
    for (int index = 0; index < elementsA1.length; index++) {
      a.add(elementsA1[index]);
    }
    for (int index = 0; index < elementsB1.length; index++) {
      b.add(elementsB1[index]);
    }
    for (int index = 0; index < expectedOutputArray1.length; index++) {
      c.add(expectedOutputArray1[index]);
    }

    if (c.equals(Demo.zip(a, b))) {
      passMessage(1);
    } else {
      failure = true;
      errorMessage(1, c.toString(), Demo.zip(a, b).toString());
    }

    methodMessage("zip()", failure);
    return failure;
  }

}
