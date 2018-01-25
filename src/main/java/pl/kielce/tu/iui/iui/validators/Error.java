package pl.kielce.tu.iui.iui.validators;

public class Error
{
    private String field;
    private String value;
    private ErrorType errorType;


    public Error(String field, String value, ErrorType errorType)
    {
        this.field = field;
        this.value = value;
        this.errorType = errorType;

    }


    public String getField()
    {
        return field;
    }


    public String getValue()
    {
        return value;
    }

    public ErrorType getErrorType()
    {
        return errorType;
    }
}
