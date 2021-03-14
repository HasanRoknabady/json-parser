package sbu.cs.parser.json;

import java.util.ArrayList;
import java.util.List;

public class Json implements JsonInterface
{
    List<FatherOfVariables> handle = new ArrayList<>();
    public Json(List<FatherOfVariables> handle)
    {
        this.handle = handle;
    }

    @Override
    public String getStringValue(String key)
    {
        for (FatherOfVariables CS : handle)
        {
            if (CS.getKey().equals(key))
            {
                return CS.getValue();
            }

        }
        return null;
    }
}
