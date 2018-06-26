package Practice6;


import Practice6.parser.DomParser;
import Practice6.parser.SaxParser;

import java.io.File;

public class Main {

    private static final String INPUT="/home/saint_satan/IdeaProjects/EpamPractices/Practice6/src/input.xml";

    public static void main(String[] args) {
        DomParser domParser=new DomParser(new File(INPUT));
        domParser.parseFile();
        domParser.sortBeers();

        SaxParser saxParser=new SaxParser(new File(INPUT));
        saxParser.parseFile();
    }

}
