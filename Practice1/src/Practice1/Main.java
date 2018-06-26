package Practice1;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====CommandLineArg");
        CommandLineArg.main(new String[]{"1", "2"});

        System.out.println("=====CommonDivisor");
        CommonDivisor.main(new String[]{"4", "8"});

        System.out.println("=====SumOfNumber");
        SumOfNumber.main(new String[]{"128"});

        System.out.println("=====Primes");
        Primes.main(new String[]{"20"});

        System.out.println("=====Numbering");
        Numbering.main(null);
    }

}

