Nat's Handy Utils
===

*CS students, rejoice!*

This is a helpful package full of gifts for good little CS-studying boys and girls, 
which should make boring exercises a lot less tedious and a *lot* more fun.

Basic Example
---

***"Write a program to input the radius of a circle, then print its area."***

```java
public class BoringCircle {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double radius = -1;
        
        do {
            System.out.print("Enter radius: ");
            
            try {
                radius = sc.nextDouble;
                if (radius < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a positive number!");
            }
            
        } while (radius < 0); 
        
        area = radius * radius * Math.PI;

        System.out.printf("Area = " + Double.toString(area));
        
    }
}
```
Lots of time wasted on error handling - **BORING!** ![ResidentSleeper](https://static-cdn.jtvnw.net/emoticons/v1/245/1.0)

```java
import static com.karmios.nat.handyutils.Input.inputDoubleLoop;

public class FunCircle {
    public static void main(String[] args){
      
        System.out.printf("Area = %s", Math.pow(inputDoubleLoop(
                "Enter radius: ", // Prompt
                "You must enter a positive number!", // Failure message
                x -> x > 0 // Predicate (acceptance condition)
        ), 2));
        
    }
}
```
*Much* better! ![PogChamp](https://static-cdn.jtvnw.net/emoticons/v1/88/1.0)

Contact me
-
Want more features?
<br>
Found a bug?
<br>
Just want to shout at me?

Tweet me (`@NatKarmios`) or message me on Discord (`Nat#1581`)!