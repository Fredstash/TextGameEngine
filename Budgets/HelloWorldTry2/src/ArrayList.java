public class ArrayList {
    int numElements;
//  I used an object because templates were being finicky
    Object[] data;

    ArrayList() {
        numElements = 0;
        data = null;
    }

    ArrayList(int size) {
        if(size <= 0){
            return;
        }
        this.data = new Object[size];
        this.numElements = 0;
    }


//  Put data on the end of the ArrayList
    void push(Object newData) {
//      Only copy and expand if there isn't empty space in the ArrayList
        if (data.length == numElements) {
            copyData(1);
            data[data.length - 1] = newData;
        }
        else {
            data[numElements] = newData;
        }
        numElements++;
    }

    Object readData(int index) {
        return this.data[index];
    }

//  Delete the last element in the ArrayList (left for functionality)
    void pop() {
        if (this.numElements > 0) {
            data[numElements - 1] = null;
            numElements--;
        }
    }

//  Delete data at an index
    void delete(int deleteIndex) {
        if (this.numElements > 0) {
            data[deleteIndex] = "";
            numElements--;

//          Make a temporary list to delete and copy data
            Object[] tempData = new Object[this.numElements + 1];
            int tempElement = 0;

//          Copy through array skipping the deleted data
            for(int i = 0; i < this.data.length; i++) {
                if (data[i] != "") {
                    tempData[tempElement] = data[i];
                    tempElement++;
                }
            }

            this.data = null;
            this.data = new Object[tempData.length];
            this.data = tempData;
        }
    }

//  Replace data in the ArrayList
    void changeData(int index, Object newObject) {
        if (index < numElements) {
            data[index] = newObject;
        }
    }

//  Used to check the transfer of data
    void readDataDEBUG(int index) {
        System.out.println("object: " + data[index]);
    }


    void copyData(int size) {

        size = increaseSize(size);

//      Temporary list for the data to be copied into
        Object[] tempData = new Object[size];
        int tempElement = 0;

//      directly copy all the data
        for(int i = 0; i < this.data.length; i++, tempElement++){
            tempData[i] = data[i];
        }

        this.data = null;
        this.data = new Object[tempData.length];
        this.data = tempData;
    }

//  Store the size change of the ArrayList
    int increaseSize(int size) {
        size = data.length + size;
        return size;
    }
}