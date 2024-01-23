import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Temperature Value : ");
        double temp=sc.nextDouble();       
        System.out.print("Enter Temperature Scale (C for Celcius, F for Fahrenhite, or K for Kelvin) : ");
        String scale=sc.next();
        double celsius;
        switch(scale.toUpperCase()) {
            case "C":
                celsius=temp;
                break;
            case "F":
                celsius=(temp-32)*5/9;
                break;
            case "K":
                celsius=temp-273.15;
                break;
            default:
                System.out.println("Enter Valid Temperature Scale");
                return;
        }
        double fahrenheit=celsius*9/5+32;
        double kelvin=celsius+273.15;
        System.out.println("Celsius: "+celsius+" C");
        System.out.println("Fahrenheit: "+fahrenheit+" F");
        System.out.println("Kelvin: "+kelvin+" K");
    }
}