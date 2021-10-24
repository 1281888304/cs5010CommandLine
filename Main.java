package problem1;

public class Main {
//吧文件
  public static void main(String[] args) {
//    System.out.println(args[0]);pwd
//    System.out.println(args[1]);

    System.out.println(args.length);

    if(args.length==3){
      String word=args[0];
      int number=Integer.parseInt(args[1]);
      double floatingnum=Double.parseDouble(args[2]);
      System.out.println("word "+word);
      System.out.println("number "+number);
      System.out.println("float number "+floatingnum);

    }else{
      System.out.println("not start add");
    }
  }

}
