package Learning;

// 文件名 : ExcepTest.java

public class ExcepTest{

    public static void main(String args[]) throws IllegalAccessException {
        try{
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown  :" + e);
        }
        System.out.println("Out of the block");

        checkNumber(-2);

    }

    public static void checkNumber(int num) throws IllegalAccessException {
        if (num < 0) {
            throw new IllegalAccessException("Number must be positive");
        }
    }
}

