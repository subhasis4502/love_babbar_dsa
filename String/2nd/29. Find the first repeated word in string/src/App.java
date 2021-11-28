import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] str = new String[size];
        for (int i = 0; i < size; i++) {
            str[i] = sc.next();
        }
        secFrequent(str);
        sc.close();
    }

    public static void secFrequent(String arr[])
    {
        HashMap<String,Integer> hash = new HashMap<>();
        
        for (String s : arr)
            hash.put(s, hash.getOrDefault(s,0)+1);
        
        String s1 = "", s2 = "";
        int max = 0, max2 = 0;
        
        for (String s : arr){
            int i= hash.get(s);
            if (i > max){
                max2=max;
                max=i;
                s2=s1;
                s1=s;
            }
            else if(i>max2 && i<max){
                max2=i;
                s2=s;
            }
        }
        
        System.out.println(s2);
    }
}
