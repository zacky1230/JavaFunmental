package char03;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 19:39.
 */
public class StringAPI {
    public static void main(String[] args) {
        String str = "Coding is a funny thing!";
        System.out.println(str.charAt(5));
        System.out.println(str.codePointAt(5));
        System.out.println(str.offsetByCodePoints(5,5));
        System.out.println(str.compareTo("Coding"));
        System.out.println(str.endsWith("thing!"));
        System.out.println(str.equals("Coding is a funny thing!"));
        System.out.println(str.equalsIgnoreCase("CODING IS A FUNNY THING!"));
        System.out.println(str.indexOf("f"));
        System.out.println(str.indexOf("f",5));
        System.out.println(str.indexOf(5));
        System.out.println(str.indexOf(5,5));
        System.out.println(str.lastIndexOf("ing"));
        System.out.println(str.lastIndexOf("ing",5));
        System.out.println(str.lastIndexOf(5));
        System.out.println(str.lastIndexOf(5,5));
        System.out.println(str.length());
        System.out.println(str.codePointCount(0,20));
        System.out.println(str.replace("ing","e"));
        System.out.println(str.startsWith("Cod"));
        System.out.println(str.substring(1));
        System.out.println(str.substring(1,10));
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.trim());
    }
}
