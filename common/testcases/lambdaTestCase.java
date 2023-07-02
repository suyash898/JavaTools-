import com.thinking.machines.utils.*;
class lambdaTestCase
{
public static void main(String gg[])
{
TMList list=new TMLinkedList();
list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.forEach((p)->{System.out.println(p);});
}
}