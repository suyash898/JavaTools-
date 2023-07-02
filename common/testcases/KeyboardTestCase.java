import com.thinking.machines.utils.*;
class KeyboardTestCase
{
public static void main(String gg[])
{
Keyboard k=new Keyboard();
String a;
System.out.print("Enter a string : ");
a=k.getString();
String b;
b=k.getString("Enter another string : ");
char c;
c=k.getCharacter("Enter Gender(M/F) : ");
long d=k.getLong("Enter a long type value : ");
int e=k.getInt("Enter a int type value : ");
short f=k.getShort("Enter a short type value : ");
byte g=k.getByte("Enter a byte type value : ");
double h=k.getDouble("Enter a double type value : ");
float i=k.getFloat("Enter a float type valus : ");
boolean j=k.getBoolean("Enter a boolean type value : ");

System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
System.out.println(g);
System.out.println(h);
System.out.println(i);
System.out.println(j);
}
}