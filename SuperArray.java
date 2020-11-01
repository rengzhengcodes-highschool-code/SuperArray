public class SuperArray {

  private String[] data;
  private int size = 0; //current array size

  public SuperArray() {
    size = 0;
    data = new String[10];
  }

  public int size()  {
    return size;
  }

  public boolean add(String element) {
    data[size] = element;
    size++;
    return true;
  }

  public String get(int index) {
    return data[index];
  }

  public String set(int index, String element) {
    String replaced = data[index];
    data[index] = element;
    return replaced;
  }

}
