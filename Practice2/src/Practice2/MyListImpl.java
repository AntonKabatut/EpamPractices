package Practice2;

import java.util.Arrays;
import java.util.Iterator;

public class MyListImpl implements MyList, ListIterable {

    private Object[] array;

    MyListImpl(){
        this.array=new Object[0];
    }

    @Override
    public void add(Object e) {
        Object[] arr;
        arr = Arrays.copyOf(array, array.length + 1);
        arr[arr.length - 1] = e;
        array = arr;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        array = new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        boolean check;
        int count=0, count1=0;
        Object[] arr=new Object[array.length-1];
        check=contains(o);
        if (check){
            for(Object object:array){
                if (o==null){
                    if (count1<1){
                        if (null ==object){
                            count1++;
                            continue;
                        }
                    }
                    arr[count++]=object;

                } else {
                    if (count1<1){
                        if (o.equals(object)){
                            count1++;
                            continue;
                        }
                    }
                    arr[count++]=object;
                }
            }
        }
        array=arr;
        return check;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Object obj : array) {
                if (obj == null) {
                    return true;
                }
            }
        }
        else  {
            for (Object obj : array) {
                if (obj==null) continue;
                if (obj.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        int count=0;
        for (Object object:c.toArray()){
            for(Object obj:this.array){
                if (object==null){
                    if (null ==obj){
                        count++;
                        break;
                    }
                }
                else {
                    if (obj==null) continue;
                    if (object.equals(obj)){
                        count++;
                        break;
                    }
                }
            }
        }
       return count==c.toArray().length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                stringBuilder.append(array[i]);
            } else {
                stringBuilder.append(array[i]).append(',');
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        int index;
        int countOfRemove;

        IteratorImpl(){
            this.index =-1;
            this.countOfRemove=-2;
        }

        // returns true if the iteration has more elements
        public boolean hasNext() {
            return this.index < array.length-1;
        }

        // returns the next element in the iteration
        public Object next() {
            countOfRemove=0;
            return array[++this.index];
        }

        // removes from the underlying collection the last element
        //returned by this iterator
        public void remove() throws IllegalStateException {
            countOfRemove++;
            if (countOfRemove<0||countOfRemove>1){
                throw new IllegalStateException();
            }
            Object[] arr = new Object[array.length - 1];
            int count=0;
            for (int i=0;i<array.length;i++){
                if (i== index){
                    continue;
                }
                arr[count++]=array[i];
            }
            index--;
            array=arr;
        }
    }


    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        int countOfSet;

        ListIteratorImpl(){
            countOfSet=-2;
        }

        @Override
        public boolean hasPrevious() {
            return index >=0;
        }

        @Override
        public Object previous() {
            countOfRemove=0;
            countOfSet=0;
            return array[index--];
        }

        @Override
        public void set(Object e) {
            countOfSet++;
            if(countOfSet<0||countOfSet>1){
                throw new IllegalStateException();
            }
            array[index]=e;
        }

        @Override
        public Object next() {
            countOfSet=0;
            return super.next();
        }
    }
}
