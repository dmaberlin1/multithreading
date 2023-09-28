package task1706;

public class OurPresident {
    private static OurPresident president;

    private OurPresident() {
    }

    static{
        synchronized (new OurPresident()){
            president=new OurPresident();
        }
    }

    public static  OurPresident getOurPresident() {
        return president;
    }
}
