import java.util.Arrays;

public class DemoTester {

  public static void main(String[] args) {
    boolean failure = false;

    failure = findOverlapTester() || failure;
    failure = zipTester() || failure;
    failure = removeDuplicatesTester() || failure;

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

  private static SuperArray defaultTestArray() {
    SuperArray test = new SuperArray();
    for (int i = 0; i < 8; i++) {
      test.add("test" + i);
    }
    return test;
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
      errorMessage(0, Arrays.toString(expectedArray), Arrays.toString(output.toArray()));
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
      errorMessage(1, Arrays.toString(expectedArray1), Arrays.toString(output.toArray()));
    }

    a.clear();
    b.clear();
    String[] expectedArray2 = {};
    output = Demo.findOverlap(a, b);
    if (Arrays.equals(output.toArray(), expectedArray2)) {
      passMessage(2);
    } else {
      failure = true;
      errorMessage(2, Arrays.toString(expectedArray2), Arrays.toString(output.toArray()));
    }

    a = defaultTestArray();
    b = defaultTestArray();
    String[] expectedArray3 = defaultTestArray().toArray();
    output = Demo.findOverlap(a, b);
    if (Arrays.equals(output.toArray(), expectedArray3)) {
      passMessage(3);
    } else {
      failure = true;
      errorMessage(3, Arrays.toString(expectedArray3), Arrays.toString(output.toArray()));
    }

    a.clear();
    String[] expectedArray4 = {};
    output = Demo.findOverlap(a, b);
    if (Arrays.equals(output.toArray(), expectedArray4)) {
      passMessage(4);
    } else {
      failure = true;
      errorMessage(4, Arrays.toString(expectedArray4), Arrays.toString(output.toArray()));
    }

    a = defaultTestArray();
    b.clear();
    output = Demo.findOverlap(a, b);
    if (Arrays.equals(output.toArray(), expectedArray4)) {
      passMessage(5);
    } else {
      failure = true;
      errorMessage(5, Arrays.toString(expectedArray4), Arrays.toString(output.toArray()));
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

    a.clear();
    b.clear();
    c.clear();
    if (c.equals(Demo.zip(a, b))) {
      passMessage(2);
    } else {
      failure = true;
      errorMessage(2, c.toString(), Demo.zip(a, b).toString());
    }

    a = defaultTestArray();
    c = defaultTestArray();
    if (c.equals(Demo.zip(a, b))) {
      passMessage(3);
    } else {
      failure = true;
      errorMessage(3, c.toString(), Demo.zip(a, b).toString());
    }

    a.clear();
    b = defaultTestArray();
    if (c.equals(Demo.zip(a, b))) {
      passMessage(4);
    } else {
      failure = true;
      errorMessage(4, c.toString(), Demo.zip(a, b).toString());
    }

    a = defaultTestArray();
    c.clear();
    for (int i = 0; i < defaultTestArray().size(); i++) {
      c.add(defaultTestArray().get(i));
      c.add(defaultTestArray().get(i));
    }
    if (c.equals(Demo.zip(a, b))) {
      passMessage(5);
    } else {
      failure = true;
      errorMessage(5, c.toString(), Demo.zip(a, b).toString());
    }

    methodMessage("zip()", failure);
    return failure;
  }

  public static boolean removeDuplicatesTester() {
    System.out.println("\n ~~~ removedDuplicates() TESTER ~~~");
    boolean failure = false;
    SuperArray[] tests = {
      new SuperArray(),//tests empty
      defaultTestArray(),//tests nonoverlap
      new SuperArray(),//tests all same
      new SuperArray(),//tests just 1
      defaultTestArray()//tests extremities simultaneously
    };
    int[] expectedSizes = {
      0,
      8,
      1,
      1,
      7,
    };
    String[] expectedStringOutputs = {
      "[]",
      "[test0, test1, test2, test3, test4, test5, test6, test7]",
      "[foo]",
      "[foo]",
      "[test0, test1, test2, test3, test4, test5, test6]"
    };
    for (int index = 0; index < 8; index++) {                         //sets a SuperArray to just "foo"
      tests[2].add("foo");
    }
    tests[3].add("foo");
    tests[4].set(7, "test0");

    for (SuperArray test : tests) {
      Demo.removeDuplicates(test);
    }

    for (int index = 0; index < tests.length; index++) {
      boolean caseFailure = false;
      if (tests[index].size() == expectedSizes[index]) {
        //System.out.println("Size for test case " + index + " checks out.");
      } else {
        caseFailure = true;
        errorMessage(index, "" + expectedSizes[index], "" + tests[index].size());
      }

      if (tests[index].toString().equals(expectedStringOutputs[index])) {
        //System.out.println("String for test case " + index + " checks out.");
      } else {
        caseFailure = true;
        errorMessage(index, "" + expectedStringOutputs[index], "" + tests[index].toString());
      }

      if (caseFailure) {
        errorMessage(index, "Check above", "Check above");
      } else {
        //passMessage(index);
      }

      failure = caseFailure || failure;
    }

    methodMessage("removeDuplicates()", failure);
    return failure;
  }

}
