package sbu.cs.parser.json;

public class DoubleVariable extends FatherOfVariables
{
    private double value;


    public void setValue(double key)
    {
        this.value = key;
    }

    @Override
    public String getValue()
    {
        return Double.toString(value);
    }
}
