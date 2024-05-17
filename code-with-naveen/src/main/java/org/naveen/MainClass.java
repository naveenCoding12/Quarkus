package org.naveen;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MainClass {
  public static void main(String[] args) {
    Quarkus.run(MainQuarkus.class);
  }

  public static class MainQuarkus implements QuarkusApplication {
    @Override
    public int run(String... args) throws Exception {
      Quarkus.waitForExit();
      return 0;
    }
  }
}
