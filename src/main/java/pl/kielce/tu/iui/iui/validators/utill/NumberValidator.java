package pl.kielce.tu.iui.iui.validators.utill;

import java.text.spi.NumberFormatProvider;
import java.util.regex.Pattern;

public class NumberValidator
{
    private static final Pattern ptr = Pattern.compile("\\d+|\\d+,\\d+|\\d+.\\d+");

    public static boolean validate(String string)
    {
        return ptr.matcher(string).matches();
    }
}
