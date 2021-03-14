package sbu.cs.parser.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser
{


    public static Json parse(String data)
    {

        List<String> listOfKeyValue = new ArrayList<>();
        data = data.replaceAll("\\s+", "");

        String check = "\"[A-Za-z0-9-]+\":";
        String findValue = "(?:\"[A-Za-z0-9-]+\"" + "|[0-9]" + "+|\\[[,1-9a-zA-Z]+]" + "+|true|false|null)";
        String matchJson =  check + findValue;

        Pattern parser = Pattern.compile(matchJson);
        Matcher matchAlgorithm = parser.matcher(data);

        while (matchAlgorithm.find())
        {
            listOfKeyValue.add( matchAlgorithm.group()
                                    .replaceAll("\"", "") );
        }

        List<FatherOfVariables> handle = new ArrayList<>();
        for (String save : listOfKeyValue)
        {
            String[] splitList = save.split(":");
            String key = splitList[0];
            String value = splitList[1];

            //this ifs handle the key and value and check what kind of variable that exist in key input
            if (value.matches("\\d*"))
            {
                IntVariable isOrNot = new IntVariable();
                isOrNot.setKey(key);
                isOrNot.setValue(Integer.parseInt(value));
                handle.add(isOrNot);
            }
            else if (value.matches("\\d*\\.\\d*"))
            {
                DoubleVariable isOrNot = new DoubleVariable();
                isOrNot.setKey(key);
                isOrNot.setValue(Double.parseDouble(value));
                handle.add(isOrNot);
            }
            else if (value.matches("true|false"))
            {
                BooleanVariable isOrNot = new BooleanVariable();
                isOrNot.setKey(key);
                isOrNot.setValue(Boolean.parseBoolean(value));
                handle.add(isOrNot);
            }
            else
            {
                StringVariable isOrNot = new StringVariable();
                isOrNot.setKey(key);
                isOrNot.setValue(value);
                handle.add(isOrNot);
            }

        }

        Json PARSINGOVER = new Json(handle);
        return PARSINGOVER;
    }

    public static String toJsonString(Json data)
    {
        return null;
    }
}
