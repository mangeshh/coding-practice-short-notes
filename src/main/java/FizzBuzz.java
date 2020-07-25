/**
 *
 * if divisible by 15 then print FizzBuzz
 * if divisible by 3 then print Fizz
 * if divisible by 5 then print Buzz
 *
 */
@SuppressWarnings("unused")
public class FizzBuzz {

    public void test(int i){
        if(i%15 == 0){
            System.out.println("FizzBuzz");
        }else if (i%3 == 0){
            System.out.println("Fizz");
        } else if(i%5==0){
            System.out.println("Buzz");
        }

    }
}
