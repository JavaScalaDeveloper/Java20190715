package JavaCoreAPI.Exception;

/*
@author 黄佳豪
@create 2019-07-22-16:45
*/
public class CustomException extends Exception {
    public static void main(String[] args) {
         int age=1111;
        if (age < 0 || age > 120) {
            AgeIllegalException e = new AgeIllegalException();
            throw e;
        }
    }
}

class AgeIllegalException extends RuntimeException {
    private static final long serialVersionUID=1L;
    public AgeIllegalException(String msg) {
        super(msg);
    }

    public AgeIllegalException() {
        super("年龄不合法，年龄应该在0-120之间！");
    }
}