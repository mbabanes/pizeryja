package pl.kielce.tu.iui.iui.validators.utill;

import java.util.regex.Pattern;

public class LetterValidator
{
    private static final Pattern ptr = Pattern.compile("[a-żA-Ż]+\\.?");

    public static boolean validate(String string)
    {
        return ptr.matcher(string).matches();
    }
}
