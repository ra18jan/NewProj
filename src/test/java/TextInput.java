import org.openqa.selenium.WebElement;

public abstract class TextInput implements WebElement {

    public void setValue(String value) {
        try {
            this.sendKeys(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Illegal argument passed %s", value));
        }

    }
}
