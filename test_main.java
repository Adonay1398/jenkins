import org.junit.jupiter.api.Test;

public class TestMain {

  @Test
  public void testMainPrintsHolaMundo() {
    // Capture the output stream to verify the printed message
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    main();

    // Assert that the expected message is present in the output
    assertEquals("Hola Mundo\n", outContent.toString());
  }
}
