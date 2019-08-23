public class Stat {
    public static void main(String[] args){
        System.out.println("Hello world");

        Audi au=new Audi();
        Volvo volvv=new Volvo();
        Car car=new Audi();

        car.start();

        compare(3,5);

        System.out.println(reminder(100,102));
    }



    public static int compare(int a,int b){
        if(a>b) return a;
        return b;
    }

    public static int reminder(int x, int y){
        int a = x/y;
        return x-a*y;
    }


}
