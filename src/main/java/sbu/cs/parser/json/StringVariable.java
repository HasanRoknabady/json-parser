package sbu.cs.parser.json;

public class StringVariable extends FatherOfVariables
{
    private String value;


    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue()
    {
        if(value.indexOf('[') == 0)
        {
            value = value.replaceAll(",", ", ");
        }

        return value;
    }
}
