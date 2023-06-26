迭代器模式 <br>
Iterator模式用于在数据集合中按照顺序遍历集合。

```mermaid
classDiagram
class Aggregate
class Iterator
class BookShelf
class BookShelfIterator
class Book

class Aggregate {
    iterator()
}

class Iterator {
    hasNext()
    next()
}

class BookShelf {
    books
    last
    getBookAt()
    appendBook()
    getLength()
    iterator()
}

class BookShelfIterator {
    bookShelf
    index
    hasNext()
    next()
}

class Book {
    name
    getName()
}
Iterator <-- Aggregate: creates
Aggregate<|.. BookShelf
Iterator<|.. BookShelfIterator
BookShelf <-- BookShelfIterator
Book <-- BookShelf
```

| 名字               | 说明          |
|-------------------|-------------|
| Aggregate         | 表示集合的接口 |
| Iterator          | 遍历集合的接口 |
| Book              | 表示书的类    |
| BookShelf         | 表示书架的类   |
| BookShelfIterator | 遍历书架的类      |
| Main              | 测试程序行为的类    |

