public class SuperArray {

  private String[] data;
  private int size = 0; //current array size

  public SuperArray() {
    size = 0;
    data = new String[8];
  }

  public int size()  {
    return size;
  }

  public boolean add(String element) {
    if (size == data.length) {
      this.resize();
    }

    data[size] = element;
    size++;
    return true;
  }

  public String get(int index) {
    if (index < size) {
      return data[index];
    } else {
      return null;
    }
  }

  public String set(int index, String element) {
    String replaced = data[index];
    data[index] = element;
    return replaced;
  }

  private void resize() {
    String[] dataNew = new String[data.length + 8];

    for (int index = 0; index < data.length; index++) {
      dataNew[index] = data[index];
    }

    data = dataNew;
  }

  public void clear() {
    data = new String[8];
    size = 0;
  }

}
