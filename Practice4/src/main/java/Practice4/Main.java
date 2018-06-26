package Practice4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    private static final InputStream STD_IN = System.in;
    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) throws IOException {
        System.out.println("=========================== PART1");
        WordsTransformation.main(args);

        System.out.println("=========================== PART2");
        SortingInfFromFiles.main(args);

        System.out.println("=========================== PART3");
        // set the mock input
        System.setIn(new ByteArrayInputStream(
                "char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(ENCODING)));
        ParseTypes.main(args);
        // restore the standard input
        System.setIn(STD_IN);

        System.out.println("=========================== PART4");
        ParseSentences.main(args);

        System.out.println("=========================== PART5");
        // set the mock input
        System.setIn(new ByteArrayInputStream(
                "table ru^table en^apple ru^stop".replace("^", System.lineSeparator()).getBytes(ENCODING)));
        LocaleWork.main(args);
        // restore the standard input
        System.setIn(STD_IN);

    }

}
