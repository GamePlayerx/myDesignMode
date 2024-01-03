package com.xcc.designmode.no19.Iterator;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/3
 */
public class ArrayList implements List{
    public String[] names = new String[10];
    @Override
    public void add(String str) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                names[i] = str;
                break;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length && names[index] != null) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
