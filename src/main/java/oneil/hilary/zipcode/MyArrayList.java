package oneil.hilary.zipcode;

import java.util.Arrays;


/**
 * Created by hilaryoneil on 2/22/17.
 */

public class MyArrayList<T> {

    private Object[] arrayList;

    private int counter;
    //array will automatically resize after counter hits 5 thanks the ensureCapacity
    private final int DEFAULT_ARRAY_SIZE = 5;


    public MyArrayList() {
        this.counter = 0;
        arrayList = new Object[DEFAULT_ARRAY_SIZE];
    }

    public MyArrayList(int size) {
        this.counter = 0;
        arrayList = new Object[size];
    }

    public int getCounter() {
        return counter;
    }

    //thanks javadocs
    public void ensureCapacity(int minCapacity) {
        int oldCapacity = arrayList.length;
        //this makes the array bigger if I'm out of room
        if (minCapacity > arrayList.length) {
            Object[] oldArrayList = arrayList;
            //I'm adding about 1/2 of an array if I'm out of room (My default value, not Java's).
            int newCapacity = (int) Math.floor(oldCapacity * 1.5);
            //if the minCapacity input is still greater, this will reset newCapacity to minCapacity
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            //adds length to the arrayList
            //noinspection Since15
            arrayList = Arrays.copyOf(oldArrayList, newCapacity);
        }
    }

    public boolean add(T t) {
        ensureCapacity(counter + 1);
        arrayList[counter++] = t;
        return true;

    }

    public void add(int index, T t) throws IndexOutOfBoundsException {
        if (index > counter || index < 0) {
            throw new IndexOutOfBoundsException("Sorry buddy. That's not a valid index.");
        } else {
            ensureCapacity(counter + 1);
            System.arraycopy(arrayList, index, arrayList, index, counter - index);
            arrayList[index] = t;
            counter++;
        }

    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("You know you can't have negative index numbers.");
        }
        return (T) arrayList[index];
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index > counter || index < 0) {
            throw new IndexOutOfBoundsException("Sorry buddy. That's not a valid index.");
        } else {
            Object oldValue = arrayList[index];
            if ((arrayList.length - index - 1) > 0) {
                System.arraycopy(arrayList, index + 1, arrayList, index, (arrayList.length - index - 1));
            }
            arrayList[--counter] = null;
            return (T) oldValue;
        }
    }

    public boolean remove(T t) {

        for (int i = 0; i < arrayList.length; i++) {
            if (t.equals(arrayList[i])) {
                Object oldValue = arrayList[1];
                int numMoved = arrayList.length - i - 1;
                if (numMoved > 0) {
                    System.arraycopy(arrayList, (i + 1), arrayList, i, numMoved);
                }
                arrayList[--counter] = null;
                //noinspection Since15
                arrayList = Arrays.copyOf(arrayList, counter);
                return true;
            }
        }
        return false;

    }

    public int size(){
        return arrayList.length;
    }

    public T set(int index, T t) throws IndexOutOfBoundsException {
        if (index > counter || index < 0) {
            throw new IndexOutOfBoundsException("Sorry buddy. That's not a valid index.");
        } else {
            Object oldValue = arrayList[index];
            arrayList[index]= t;
            return (T) oldValue;

        }
    }

    public void clear(){
        counter = 0;
        //noinspection Since15
        arrayList = Arrays.copyOf(arrayList,counter);
    }

    //an array with a bunch of null values is empty, right?
    public boolean isEmpty(){
        for(int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null)
                return false;
        }
        return true;
        }

    public boolean contains(T t){
        for (int i = 0; i < arrayList.length; i++){
            if (arrayList[i].equals(t))
                return true;
        }
        return false;
    }


}






