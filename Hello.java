package problem1;

import java.util.Calendar;
import java.util.Scanner;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Hello {

  public static void main(String[] args) throws ParseException {
    Options options = new Options();
    options.addOption("t", "time",false, "display time");

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse( options, args);

    Calendar date = Calendar.getInstance();
    int day = date.get(Calendar.DAY_OF_MONTH);
    int month = date.get(Calendar.MONTH);
    int year = date.get(Calendar.YEAR);

    int hour = date.get(Calendar.HOUR);
    int min = date.get(Calendar.MINUTE);
    int sec = date.get(Calendar.SECOND);

    System.out.print(day + "/" + month + "/" + year);
    if(cmd.hasOption("t")) {
      System.out.print(" " + hour + ":" + min + ":" + sec);
    }
  }

}
