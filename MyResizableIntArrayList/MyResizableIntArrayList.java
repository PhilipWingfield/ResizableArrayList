/**
 * Class MyResisableIntArrayList.
 * The capacity is doubled when the array becomes full. 
 * The capacity is halfed when the size of the structure becomes less than or equal to the 1/4th of the cap.
 *
 * @author Filippos Ouingkfilnt
 * @version 2022
 */
public class MyResizableIntArrayList 
{    
    private int[] data;
    private int cap;
    private int size;
    public MyResizableIntArrayList() 
    //Constructs a resizable array-list of integers.
    {
        data = new int[1];
        cap = 1;
        size=0;
    }
    public MyResizableIntArrayList(int initialCap)
    //Constructs a resizable array-list of integers.
    {
        cap = initialCap;
        data = new int[initialCap];
        size=0;
    }
    private void ArrayIsFull() 
    //When array is full this method doubles its capacity by coping its elements to a new array with double capacity of the old one.
    {
        int[] copy = new int[2 * cap];
        for(int i = 0; i < cap; i++)
        {
            copy[i] = data[i];
        }
        data = copy;
        cap = cap*2;  
    }
    private void ArrayShrink()
    //When the array cap becomes 4 times greater than the number of elements it contains, while removing elements the array capacity becomes half.
    //We also copy the elements to a new array
    {
        if(size==4*cap) {
            int array[]=new int[cap/2];
            for(int i = 0; i< size; i++)
            {
                array[i]=data[i];
            }
            data = array;
            cap=cap/2;
        }
    }
    public void add(int elem)
    //Appends the specified element to the end of this resizable array-list.
    //The size of the resizable array-list is increased by one.
    {
        if (size == cap)
        {    
            this.ArrayIsFull();
        }
        data[size] = elem;
        size++;
    }
    public void add(int index, int elem)
    //Inserts the specified element at the specified position in this resizable array-list.
    //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices). 
    //The size of the resizable array-list is increased by one.
    //It assumes that index has an appropriate value, that is, (index >= 0 && size() >=index)
    {
        if(size == cap)
        {
            this.ArrayIsFull();
        }
        for(int j = size-1; j >= index; j--)
        {
            data[j+1] = data[j];
        }
        data[index] = elem;
        size++;
    }    
    public void clear()  
    //Removes all the elements of the array-list and resets its capacity to 1.
    {
        data=new int[1];
        size=0;
        cap=1;
    }
    public boolean contains(int elem) 
    //Checks whether this array-list contains a specific element.
    //return "true" if this array-list contains the specified element, "false" otherwise.
    {
        return indexOf(elem) >= 0;
    }
    public int get(int index)
    //Returns the element at the specified position in this array-list.
    //It assumes that index has an appropriate value, that is, (index >= 0 && size() > index).
    {
        return data[index];
    }
    public int indexOf(int elem)
    //Searches for the first occurence of the given argument.
    //Returns the index of the first occurrence of the argument in this array-list, otherwise returns -1 if the object is not found.
    {
        for(int i= 0; i < size; i++) 
        {
            if(elem==data[i])
            { 
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty()
    //Tests if this array-list is empty.
    {
        return size == 0;
    }
    public void remove(int index) 
    // Removes the element at the specified position in this array-list.
    //Shifts any subsequent elements to the left (subtracts one from their indices). 
    //It assumes that index has an appropriate value, that is, (index >= 0 && size() > index).
    {
        this.ArrayShrink();
        for(int i = index; i< size-1; i++)
        {    
            data[i]=data[i+1];
        }
        data[size-1]=0;
        size--;
    }
    public void set(int index, int elem) 
    //Replaces the element at the specified position in this array-list with the specified element. 
    //It assumes that index has an appropriate value, that is, (index >= 0 && size() >index)
    {
        data[index] = elem;
        size++;
    }
    public int size()
    //The size of this array-list.
    {
        return size;
    }
    
}