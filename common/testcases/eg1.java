import com.thinking.machines.utils.*;
class psp
{
public static void main(String gg[])
{
TMList<Integer> list=new TMArrayList<Integer>();
list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.forEach((p)->{System.out.println(p);});
TMList<String> i=new TMLinkedList<String>();
i.add("Ujjain");
i.add("Indore");
i.add("goa");
i.add("pune");
i.forEach((p)->{System.out.println(p);});
}
}