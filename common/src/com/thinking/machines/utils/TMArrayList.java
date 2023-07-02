package com.thinking.machines.utils;
public class TMArrayList<T> implements TMList<T>
{
private Object collection[];
private int size;
public class TMArrayListIterator<T> implements TMIterator<T>
{
private int index;
public TMArrayListIterator()
{
this.index=0;
}
public boolean hasNext()
{
return index!=size; //inner class can access member of outer class
}
public T next()
{
if(index==size) throw new InvalidIteratorException("Iterator has no more elements");
T data=(T)get(index);
index++;
return data;
}
}
public TMIterator iterator()
{
return new TMArrayListIterator();
}
public TMArrayList()
{
this.collection=new Object[10];
this.size=0;
}
public void removeAll()
{
this.clear();
}
public void clear()
{
this.size=0;
}
public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
T data=(T)this.collection[index];
int ep=this.size-2;
for(int e=index;e<=ep;e++)
{
this.collection[e]=this.collection[e+1];
}
this.size--;
return data;
}
public void add(T data)
{
if(this.size==collection.length)
{
Object []tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++)
{
tmp[e]=collection[e];
}
this.collection=tmp;
}
this.collection[size]=data;
this.size++;
}
public void add(int index,T data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(this.size==collection.length)
{
Object []tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++)
{
tmp[e]=collection[e];
}
this.collection=tmp;
}
for(int e=this.size;e>index;e--)
{
this.collection[e]=this.collection[e-1];
}
this.collection[index]=data;
this.size++;
}
public void insert(int index,T data)
{
this.add(index,data);
}
public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid Exception : "+index);
return (T)this.collection[index];
}
public int size()
{
return this.size;
}
public void update(int index,T data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
this.collection[index]=data;
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
for(int e=0;e<this.size;e++) a.accept((T)collection[e]);
}
}