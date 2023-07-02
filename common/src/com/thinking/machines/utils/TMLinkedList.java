package com.thinking.machines.utils;
public class TMLinkedList<T> implements TMList<T>
{
private class TMNode<T>
{
public T data;
public TMNode<T> next;
}
private TMNode<T> start,end;
private int size;
public class TMLinkedListIterator<T> implements TMIterator<T>
{
private TMNode<T> ptr;
TMLinkedListIterator(TMNode<T> ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
T data=this.ptr.data;
this.ptr=this.ptr.next;
return data;
}
}
public TMIterator<T> iterator()
{
return new TMLinkedListIterator(this.start);
}
public TMLinkedList()
{
this.start=null;
this.end=null;
}
public void add(T data)
{
TMNode t;
t=new TMNode();
t.data=data;
if(start==null)
{
this.start=this.end=t;
}
else
{
this.end.next=t;
this.end=t;
}
this.size++;
}
public void add(int index,T data)
{
if(index<0) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(index>=size) //if index is greater than size then also we are adding at last
{
add(data);
return;
}
TMNode<T> t;
t=new TMNode<T>();
t.data=data;
if(index==0)
{
t.next=this.start;
this.start=t;
}
else
{
TMNode<T> p1,p2=null;
p1=start;
for(int e=0;e<index;e++)
{
p2=p1;
p1=p1.next;
}
p2.next=t;
t.next=p1;
}
this.size++;
}
public void insert(int index,T data)
{
this.add(index,data);
}
public void update(int index,T data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(index==0)
{
this.start.data=data;
return;
}
if(index==this.size-1)
{
this.end.data=data;
return;
}
TMNode<T> p1;
p1=start;
for(int e=0;e<index;e++) 
{
p1=p1.next;
}
p1.data=data;
}
public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid Index : "+index);
T data;
if(start==end) //only one node is present
{
data=this.start.data;
this.start=null;
this.end=null;
this.size=0;
return data;
}
if(index==0) //many but remove first
{
data=this.start.data;
this.start=this.start.next;
this.size--;
return data;
}
TMNode<T> p1,p2=null;
p1=start;
for(int e=0;e<index;e++)
{
p2=p1;
p1=p1.next;
}
data=p1.data;
p2.next=p1.next;
if(this.end==p1) this.end=p2;
this.size--;
return data;
}
public void removeAll()
{
this.clear();
}
public void clear()
{
this.size=0;
this.start=null;
this.end=null;
}
public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
TMNode<T> t;
t=this.start;
for(int e=0;e<index;e++) t=t.next;
return t.data;
}
public int size()
{
return this.size;
}
public void copyTo(TMList<T> other)
{
other.clear();
for(int e=0;e<this.size();e++) other.add(this.get(e));
}
public void copyFrom(TMList<T> other)
{
this.clear();
for(int e=0;e<other.size();e++) this.add(other.get(e));
}

public void appendTo(TMList<T> other)
{
for(int e=0;e<this.size();e++) other.add(this.get(e));
}
public void appendFrom(TMList<T> other)
{
for(int e=0;e<other.size();e++) this.add(other.get(e));
}
public void forEach(TMListItemAcceptor<T> a)
{
if(a==null) return;
TMNode<T> t;
for(t=start;t!=null;t=t.next) a.accept(t.data);
}
}