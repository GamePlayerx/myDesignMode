package com.xcc.designmode.Iterator模式;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("西游记百会文"));
        bookShelf.appendBook(new Book("红楼梦"));
        bookShelf.appendBook(new Book("三国演义"));
        bookShelf.appendBook(new Book("水浒传"));
        bookShelf.appendBook(new Book("java"));
        bookShelf.appendBook(new Book("c++"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
