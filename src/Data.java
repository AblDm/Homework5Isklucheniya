import javax.swing.text.AttributeSet;
import java.util.Objects;

public class Data {
    String login;
    String password;
    String confirmPassword;

    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    protected static boolean validate(String login, String password, String confirmPassword) {

        try {
            check (login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println (e.getMessage ());
            return false;
        }
        return true;
    }


    public static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!validate (login)){
            throw new WrongLoginException ("LOGIN IS NOT VALID!");
        }
        if (!validate (password)){
            throw new WrongPasswordException ("PASSWORD IS NOT VALID!");
        }
        if (!password.equals (confirmPassword)){
            throw new WrongPasswordException ("PASSWORDS IS NOT EQUALS");
        }
    }

    private static boolean validate(String s) {
        if (s.length () > 20) {
            return false;
        }

        for (int i = 0; i < s.length (); i++) {
            if (!VALID_CHARACTERS.contains (String.copyValueOf (new char[]{s.charAt (i)}))) {
                return false;
            }
        }
        return true;
    }
}
