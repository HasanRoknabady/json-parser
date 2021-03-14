package sbu.cs.parser.json;

public class BooleanVariable extends FatherOfVariables
//this class i like that because remember me this : "MOTHER OF DRAGONS" ???!!!
{
    private boolean value;


    public void setValue(boolean value)
    {
        this.value = value;
    }

    @Override
    public String getValue()
    {
        return Boolean.toString(value);
    }
}
