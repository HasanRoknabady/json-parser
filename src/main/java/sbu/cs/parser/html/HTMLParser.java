package sbu.cs.parser.html;


public class HTMLParser
{
    public static Node parse(String document)
    {
        // d equal doucument with trim and delet \n
        String d = document
                           .replaceAll("\n", "")
                                                                 .trim();

        Node node = new Node(d);
        d = removeTagName(d);

        if(!d.contains("<"))
        {
            return node;
        }

        while(d.length() != 0)
        {
            node.addChild(firstTag(d));
            d = removeTag(d);
        }

        return node;
    }



     // we get html data here to see and ...
    private static Node firstTag(String htmlData)
    {
        String tmp = htmlData.substring(htmlData.indexOf('<'), htmlData.indexOf('>') + 1);

        if((htmlData.indexOf('<') + 1) == (htmlData.indexOf('/')))
        {
            return new Node(tmp.trim());
        }
        else
        {
            String openTag = tmp;

            String tagName = htmlData
                    .substring(htmlData.indexOf('<') + 1, Math.min(htmlData.indexOf('>'), htmlData.indexOf(' ')));

            String closeTag = "</" + tagName + ">";

            String tag = htmlData
                    .substring(htmlData.indexOf(openTag) + openTag.length(), htmlData.indexOf(closeTag)).trim();

            return new Node(openTag + tag + closeTag);
        }
    }


    private static String removeTag(String htmlData)
    {
        String temp = htmlData.substring(htmlData.indexOf('<'), htmlData.indexOf('>') + 1);

        if((htmlData.indexOf('<') + 1) == (htmlData.indexOf('/')))
        {
            return htmlData.replaceFirst(temp, "").trim();
        }
        else
        {
            String openTag = temp;
            String tagName = htmlData
                                     .substring(htmlData.indexOf('<') + 1, Math.min(htmlData.indexOf('>'), htmlData.indexOf(' ')));
            String closeTag = "</" + tagName + ">";
            String tag = htmlData
                                     .substring(htmlData.indexOf(openTag) + openTag.length(), htmlData.indexOf(closeTag));
            String handle = htmlData.replaceFirst(openTag + tag + closeTag, "").trim();
            return handle;
        }

    }



    private static String removeTagName(String htmlData)
    {
        String openTag = htmlData
                                 .substring(htmlData.indexOf('<'), htmlData.indexOf('>') + 1);

        int temp = Math.min(htmlData.indexOf('>'), htmlData.indexOf(' '));
        int idx;
        if (temp < 0)
        {
            idx = htmlData.indexOf('>');
        }
        else
        {
            idx = temp;
        }

        String tagName = htmlData.substring(htmlData.indexOf('<') + 1, idx);
        String closeTag = "</" + tagName + ">";
        String handle = htmlData.replaceFirst(openTag, "").replaceFirst(closeTag, "");

        return handle;
    }


}
