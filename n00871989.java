//Nathan Wheeler N00871989. Assignment 3
import java.io.*; // for I/O
import java.util.*;
////////////////////////////////////////////////////////////////
class Link
{
public long dData; // data item
public Link next; // next link in list
// -------------------------------------------------------------
public Link(long dd) // constructor
{ dData = dd; }
// -------------------------------------------------------------
public void displayLink() // display ourself
{ System.out.print(dData + " "); }
} // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
private Link first; // ref to first item on list
// -------------------------------------------------------------
public LinkList() // constructor
{ first = null;
    } // no items on list yet
// -------------------------------------------------------------
public Link getFirst() // get value of first
{ return first; }
// -------------------------------------------------------------
public void setFirst(Link f) // set first to new link
{ first = f; }
// -------------------------------------------------------------
public boolean isEmpty() // true if list is empty
{ return first==null; }
// -------------------------------------------------------------
public ListIterator getIterator() // return iterator
{
return new ListIterator(this); // initialized with
} // this list
// -------------------------------------------------------------
public void displayList()
{
Link current = first; // start at beginning of list
current.displayLink(); // print data
System.out.println("");
}
// -------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////
class ListIterator
{
private Link current; // current link
private Link previous; // previous link
private Link last;
private Link holder;
private LinkList ourList; // our linked lis
//--------------------------------------------------------------
public ListIterator(LinkList list) // constructor
{
ourList = list;
reset();
}
//--------------------------------------------------------------
public void reset() // start at ‘first’
{
current = ourList.getFirst();
previous = null;
}
//--------------------------------------------------------------
public void setHolder(Link a){
   holder = a;
}
//--------------------------------------------------------------
public Link getHolder(){
return holder;
}
//--------------------------------------------------------------
public boolean atEnd() // true if last link
{ return (current.next==null); }
//--------------------------------------------------------------
public void nextLink() // go to next link
{
previous = current;
current = current.next;
}
//--------------------------------------------------------------
public Link getCurrent() // get current link
{ return current; }

public Link getLast() // get current link
{ return last; }
//--------------------------------------------------------------
public void insertAfter(long dd) // insert after
{ // current link
Link newLink = new Link(dd);
if( ourList.isEmpty() ) // empty list
{
ourList.setFirst(newLink);
current = newLink;
last = newLink;
last.next = ourList.getFirst();
}
else // not empty
{
last = newLink;
last.next = ourList.getFirst();
newLink.next = current.next;
current.next = newLink;
nextLink(); // point to new link
}
}
//--------------------------------------------------------------
public long deleteCurrent() // delete item at current
{
long value = current.dData;
if(previous == null) // beginning of list
{
ourList.setFirst(current.next);
reset();
}
else // not beginning
{
previous.next = current.next;
if( atEnd() )
reset();
else
current = current.next;
}
return value;
}
} // end class ListIterator
////////////////////////////////////////////////////////////////
class n00871989
{
public static void main(String[] args) throws IOException
{
while(true)
{
System.out.print("Enter a sequence of 3 ints, or type, \"stop\" to end the program.");
Scanner sc = new Scanner(System.in);
String input;
input = sc.nextLine();

if (input.equals("stop")){
System.out.println("\"stop\" was entered. Stopping program.");
return;
}

else{
//assumes user entered 3 ints

String[] strArray = input.split("\\s+");
int[] intArray = new int[strArray.length];

for(int i = 0; i < strArray.length; i++){
   intArray[i] = Integer.parseInt(strArray[i]);
}
int nLinks = intArray[0];
int startingPoint = intArray[1];
int nMoves = intArray[2];

// LInked List Operations

LinkList theList = new LinkList(); // new list
ListIterator iter1 = theList.getIterator(); // new iter

//iterator 1 to add links
long value;
for (int i = 0; i < nLinks; i++){
if (i == startingPoint){
iter1.setHolder(iter1.getCurrent());
//iter1.getHolder().displayLink();System.out.println("");
}
iter1.insertAfter(i+1);
}
//loop while linked list size > 1, then display link left over
for(int i = nLinks; i>2; i--){
   for (int k = 0; k< nMoves; k++){
      //iter1.getHolder().displayLink();
      iter1.nextLink();
   }
   //iter1.getHolder().displayLink();
   //iter1.getCurrent().displayLink();
   iter1.deleteCurrent();
   theList.setFirst(iter1.getCurrent().next);
   }
//current = iter1(startingPoint);
theList.displayList();

System.out.flush();
}

} // end while
} // end main() 4

//-------------------------------------------------------------
} // end class InterIterApp
////////////////////////////////////////////////////////////////