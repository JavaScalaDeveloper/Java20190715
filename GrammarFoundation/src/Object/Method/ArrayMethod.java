package Object.Method;

/*
@author 黄佳豪
@create 2019-07-18-19:13
*/
public class ArrayMethod {
    public static void main(String[] args) {
        ArrDemo a1 = new ArrDemo();
        Book b = new Book();
        b.name = "daf";
        b.price=12;
        String bs = b.toString();
        a1.setBookPrice(b);
        int[] src = {2, 4, 5};
        int[] dest = a1.arrayCopy(src, src.length + 1);
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i]+"\t");

        }
        System.out.println();
        a1.copyBook(b);
        b.toString();
    }
}

class ArrDemo {
    public void setBookPrice(Book book) {
        System.out.println("book's price is"+book.price+book.toString());
    }

    public int[] arrayCopy(int[] src,int len) {
        int[] dest = new int[len];//新数组
        int length=len<src.length?len:src.length;//返回长数组
        for (int i = 0; i <length; i++) {
            dest[i] = src[i];
        }
        return dest;
    }

    public Book copyBook(Book book) {
        System.out.println(book.toString());
        return book;
    }
}

class Book {
    String name;
    int price;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}