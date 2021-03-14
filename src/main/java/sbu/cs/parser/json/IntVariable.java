package sbu.cs.parser.json;

public class IntVariable extends FatherOfVariables
{
    private int value;


    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public String getValue()
    {
        return Integer.toString(value);
    }
}
