package algorithms4;

//一串01串，每4个0后就加个1
public class liu1 {

    public static void main(String[] args)
    {
        String s = "";
        for(int i=0;i<100;i++)
        {
            if(Math.random()>0.5)s+="1";
            else s+="0";
        }
        System.out.println(s);

        for(int i=0;i<s.length()-3;i++)
        {
            String temp = s.substring(i,i+4);
            if(!temp.equals("0000")) ;
                else if(i==s.length()-4)s+="1";
                else s=s.substring(0,i+4)+"1"+s.substring(i+4);
        }
        System.out.println(s);

    }

}
