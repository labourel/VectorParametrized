import java.util.Collection;

/**
 * The {@code ArrayVector} class implements the {@code Vector} interface.
 * An array is used to store the components of the vector.
 */

public class ArrayVector<E> implements Vector<E> {
    /**
     * The array buffer into which the components of the vector are
     * stored. The capacity of the vector is the length of this array buffer,
     * and is at least large enough to contain all the vector's elements.
     *
     * <p>Any array elements following the last element in the Vector are null.
     *
     */
    private Object[] elementData;

    /**
     * The number of valid components in this {@code Vector} object.
     * Components {@code elementData[0]} through
     * {@code elementData[elementCount-1]} are the actual items.
     *
     */
    protected int elementCount;
    /**
     * Construct a vector with the specified capacity and size 0.
     *
     * @param capacity the capacity of the vector
     */
    public ArrayVector(int capacity){
        this.elementData = new Object[capacity];
        this.elementCount = 0;
    }
    /**
     * Construct a vector with capacity 10 and size 0.
     *
     */
    public ArrayVector(){
        this(10);
    }

    @Override
    public void setSize(int newSize) {
        this.elementCount = newSize;
    }

    @Override
    public int capacity() {
        return elementData.length;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o, int index) {
        for(int i = index; i < size(); i++){
            if(o.equals(get(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOf(Object o) {
        return this.indexOf(o, 0);
    }

    @Override
    public int lastIndexOf(Object o, int index) {
        for(int i = index; i >= 0; i--){
            if(o.equals(get(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return lastIndexOf(o, size()-1);
    }

    @Override
    public E firstElement() {
        return null;
    }

    @Override
    public E lastElement() {
        return null;
    }

    @Override
    public void insertElementAt(E obj, int index) {

    }

    @Override
    public void removeAllElements() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        Object result = elementData[index];

        elementData[index] = element;

        return (E) result;
    }

    @Override
    public boolean add(E e) {
        if(size()==capacity())
            return false;
        setSize(size()+1);
        set(size()-1, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int position = indexOf(o);
        if (position == -1){
            return false;
        }
        remove(position);
        return true;
    }

    @Override
    public E remove(int index) {
        E result = get(index);

        for(int i = index; i<size()-1; i++){
            set(i, get(i+1));
        }
        setSize(size()-1);
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
}

