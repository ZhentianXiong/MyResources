package algorithms4;

//String各种用法
public class string {

    public static void main(String[] args)
    {
        String string1 = new String("xiong");
        String string2 = new String("z h e n");
        String string3 = "tian";

        System.out.println(string1.length());
        System.out.println(string2.charAt(1));
        System.out.println(string1.indexOf("o"));
        System.out.println(string1.indexOf("o",2));
        System.out.println(string1.concat("is"));
        System.out.println(string1+string3);
        System.out.println(string1.substring(0,3));
        System.out.println(string2.split(" ")[2]);//分割完是string数组，直接打印是内存地址
        System.out.println(string2.split("\\s+")[2]);//用正则表达式分割：一个或多个制表符、空格、换行符、回车
        System.out.println(string1.compareTo("xion"));//直接比较大小，会出现-1，0（相等），1
        System.out.println(string1.equals("xiong"));//相同为true
        System.out.println(string1.contains("io"));
        System.out.println(string3.hashCode());
        System.out.println(string1.getClass());
    }

}
