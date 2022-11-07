public class MyMath {
    public static boolean isPrim(int szam){
        for (int i = 2; i < Math.sqrt(szam); i++)
            if(szam%i==0) return false;
        return true;
    }

    public static double abs(double x){
        return (x>=0) ? x : -x;
    }

    public static int pow(int x, int n){
        return (n == 0) ? 1 : (n == 1) ? x : pow(x,n-1)*x;
    }
}
