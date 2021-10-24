package problem1;

import java.io.PrintWriter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Cml {

  private static final Option ARG_ADD = new Option("a", "add", false, "Add to number together");
  private static final Option AGE_SUB = new Option("s", "subtraction", false,
      "subtraction to number together");
  private static final Option ARG_MUL = new Option("m", "multiplication", false,
      "multiple to number together");
  private static final Option ARG_DIV = new Option("d", "division", false,
      "division to number together");
  private static final Option ARG_MIN = new Option(null, "minus", false,
      "after result do minus operation");
  private static final Option ARG_DO = new Option(null, "doit", true,
      " result do minus");

  public static void main(String[] args) {

    CommandLineParser clp = new DefaultParser();

    //crete a list of option
    Options options = new Options();
    options.addOption(ARG_ADD);
    options.addOption(AGE_SUB);
    options.addOption(ARG_MUL);
    options.addOption(ARG_DIV);
    options.addOption(ARG_MIN);
    options.addOption(ARG_DO);

    int a=0,b=0;

    try {
      //change it to input, args is the list

      CommandLine cl = clp.parse(options, args);

      if(cl.getArgList().size()<2){
        printHelp(options);
        //not a valid input
        System.exit(-1);
      }

       a=Integer.parseInt(cl.getArgList().get(0));
       b=Integer.parseInt(cl.getArgList().get(1));

      //here is command line we can work with
      if (cl.hasOption(ARG_ADD.getLongOpt())) {
        System.out.println(a+b);

      } else if (cl.hasOption(AGE_SUB.getLongOpt())) {
        System.out.println(a-b);
      } else if (cl.hasOption(ARG_MUL.getLongOpt())) {
        System.out.println(a*b);
      } else if (cl.hasOption(ARG_DIV.getLongOpt())) {
        System.out.println(a / b);
      } else {
        //print command line if we current don't have this command line
        printHelp(options);
      }

      if (cl.hasOption(ARG_MIN.getLongOpt())) {
        String val=cl.getOptionValue(ARG_MIN.getLongOpt());
        int total=a-(Integer.parseInt(val));
        System.out.println(total);
      }

      if (cl.hasOption(ARG_DO.getLongOpt())) {

        System.out.println("dooooooo!");
      }

    } catch (ParseException e) {
      e.printStackTrace();
    }

  }

  private static void printHelp(Options options){
    HelpFormatter formatter=new HelpFormatter();
    PrintWriter pw=new PrintWriter(System.out);
    pw.println("MathApp "+Math.class.getPackage().getImplementationVersion());
    pw.println();
    formatter.printUsage(pw,100,"java -jar MathAPP.jar [options] input1 input2");
    formatter.printOptions(pw,100,options,2,5);
    pw.close();

  }


}
