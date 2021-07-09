package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class HtmlTextConverterTest {

  @Test
  public void foo() {
    HtmlTextConverter converter = new HtmlTextConverter("C:\\Users\\Attila_Varga2\\!stuff\\CodeKata\\Racing-Car-Katas\\TextConverter\\src\\test\\java\\resources\\testText.txt");
    assertEquals("C:\\Users\\Attila_Varga2\\!stuff\\CodeKata\\Racing-Car-Katas\\TextConverter\\src\\test\\java\\resources\\testText.txt", converter.getFilename());
  }
    @Test
    public void foo2() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("C:\\Users\\Attila_Varga2\\!stuff\\CodeKata\\Racing-Car-Katas\\TextConverter\\src\\test\\java\\resources\\testText.txt");
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br />Fusce elementum vitae mi vitae vehicula.<br /><br />Praesent interdum id eros sit amet hendrerit.<br />Donec imperdiet lectus magna, tempor aliquet leo facilisis lobortis.<br />", converter.convertToHtml());
    }
}
