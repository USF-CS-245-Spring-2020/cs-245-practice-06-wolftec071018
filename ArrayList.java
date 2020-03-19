
public class ArrayList<T> implements List<T> {

    private T[] a;
    private int size;

    public ArrayList() {

        a = (T[]) new Object[10];
    }

    public void add(T data) {
        if (size == a.length)
            growArray();
        a[size++] = data;
    }

    // add data to a index
    public void add(int pos, T data) {
        //checks if pos is at least 0/non-neg 
        if(size == a.length)
        growArray();
    
    if(pos > size || pos < 0){// do nothing
    }
    
    for(int i = size; i > pos; i--) 
    {      
        a[i] = a[i-1];
    }
    
    a[pos] = data;
    size++;

    }

    void growArray() {
        //makes a newarray twice the size
        T[] newArray = (T[]) new Object[a.length * 2];
        System.arraycopy(a, 0, newArray, 0, a.length);
        a = newArray;

    }

    public T get(int pos) {
        if (pos >= size || pos < 0) //throw new Exception("Out of Bound")
        return null;

        else
        return a[pos];

    }

    public T remove(int pos) {
        //set a temp
        T temp = a[pos];
        if(pos >= size || pos < 0 || size == 0)
            return null;
        
        for(int i = pos; i < size-1; i++) {
            
            a[i] = a[i+1];
        }
        
        size--;
        return temp;          


    }

    public int size() {

        return size;
    }

}