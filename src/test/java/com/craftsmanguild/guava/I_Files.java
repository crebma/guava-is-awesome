package com.craftsmanguild.guava;

import static com.google.common.io.Files.deleteRecursively;

import java.io.File;

import org.junit.Test;

public class I_Files {

  @Test
  public void fileMagic() throws Exception {
    deleteRecursively(new File("/home/amber/Desktop/guava/"));
  }
}
