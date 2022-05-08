public class ArrayList {
    int numElements;
    Object[] data;

    ArrayList() {
        this.numElements = 0;
        this.data = null;
    }

    ArrayList(int size) {
        if (size > 0) {
            this.data = new Object[size];
            this.numElements = 0;
        }
    }

    void push(Object newData) {
        if (this.data.length == this.numElements) {
            this.copyData(1);
            this.data[this.data.length - 1] = newData;
        } else {
            this.data[this.numElements] = newData;
        }

        ++this.numElements;
    }

    Object readData(int index) {
        return this.data[index];
    }

    void pop() {
        if (this.numElements > 0) {
            this.data[this.numElements - 1] = null;
            --this.numElements;
        }

    }

    void delete(int deleteIndex) {
        if (this.numElements > 0) {
            this.data[deleteIndex] = "";
            --this.numElements;
            Object[] tempData = new Object[this.numElements + 1];
            int tempElement = 0;

            for(int i = 0; i < this.data.length; ++i) {
                if (this.data[i] != "") {
                    tempData[tempElement] = this.data[i];
                    ++tempElement;
                }
            }

            this.data = null;
            this.data = new Object[tempData.length];
            this.data = tempData;
        }

    }

    void changeData(int index, Object newObject) {
        if (index < this.numElements) {
            this.data[index] = newObject;
        }

    }

    void readDataDEBUG(int index) {
        Object var10001 = this.data[index];
        System.out.println("object: " + var10001);
    }

    void copyData(int size) {
        size = this.increaseSize(size);
        Object[] tempData = new Object[size];
        int tempElement = 0;

        for(int i = 0; i < this.data.length; ++tempElement) {
            tempData[i] = this.data[i];
            ++i;
        }

        this.data = null;
        this.data = new Object[tempData.length];
        this.data = tempData;
    }

    int increaseSize(int size) {
        size += this.data.length;
        return size;
    }
}
