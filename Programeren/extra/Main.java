package extra;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String title = scanner.nextLine();
    String extra = scanner.nextLine();

    Test.launch(Test.class, --organization = title,
    extra);
  }
}
