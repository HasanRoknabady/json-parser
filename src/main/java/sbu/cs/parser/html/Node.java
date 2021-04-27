package sbu.cs.parser.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements NodeInterface
{
    //this private method shoud be here to use
    private String value;
    private Map<String, String> attributes = new HashMap<>();
    private List<Node> children = new ArrayList<>();

    ////////////////////////////////////////////
    public void addChild(Node child)
    {
        children.add(child);
    }
    @Override
    public String getAttributeValue(String key)
    {
        return attributes.get(key);
    }
    /////////////////////////////////////////////

    @Override
    public List<Node> getChildren()
    {
        for(int count = 0; count < children.size(); count++)
        {
            Node temp = HTMLParser.parse(children.get(count).value);
            children.set(count, temp);
        }

        List<Node> handle = children;
        return handle;
    }


    //this method that we use in try catch that shoud
    //find attribute and we shoud use
    // throws exeption after this method
    private void  attributeFinder() throws Exception
    {
        if(!value.contains("="))
            return;

        String[] temp = value.substring(value.indexOf(" ") + 1, value.indexOf(">") + 1).
                replace('>', ' ').split("\" ");

        for (String s : temp)
        {
            s = s.replaceAll("\"", "");
            //find key value
            attributes.put(s.split("=")[0], s.split("=")[1]);
        }

    }

          //this is for get value and set it and
         //after that we use attributeFinder() function
        //with try catch method throws exeption
    public Node(String value)
    {
        this.value = value;

        try
        {
            attributeFinder();
        }
        catch(Exception e) {}
    }



        // THIS function return string that contain information
       // between two firs and last tag
      // and its not tag that start with </ we have if to remove this
    @Override
    public String getStringInside()
    {
        int fIdx = value.indexOf('<');
        //index of last tag + 1
        int lIdx = value.indexOf('>') ;
        //string of openning
        if((fIdx + 1) == (value.indexOf('/')))
            return null;
        //index of first tag
        String oTag = value.substring(fIdx, lIdx + 1);
        //in this case we find name that come before space
        int beforeTagName = Math.min(lIdx, value.indexOf(' '));
        String tagName = value.substring(fIdx + 1, beforeTagName);
        //string of closing
        String cTag = "</" + tagName + ">";
        //we can get inside of ...
        String tag =
                   value
                        .substring(value.indexOf(oTag) + oTag.length(), value.indexOf(cTag))
                                                                                                .trim();

        //getting tag from that contains inside string
        return tag;
    }






}
