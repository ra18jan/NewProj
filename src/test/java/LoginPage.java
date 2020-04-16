import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest {

    @FindBy(id = "username")
    private TextInput userId;

    public TextInput getUserId() {
        return userId;
    }

    @FindBy(id = "password")
    private TextInput password;

    public TextInput getPassword() {
        return password;
    }

    public void setUserId(String usrId) {
        userId.setValue(usrId);
    }

    public void setPassword(String pwd) {
        password.setValue(pwd);
    }


}
