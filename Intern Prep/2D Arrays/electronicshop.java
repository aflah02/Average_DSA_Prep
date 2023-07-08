import java.util.ArrayList;

public class electronicshop {
    public static void main(String[] args) {

    }
}
class mechanic {
    ArrayList<replacemotherboard> replacemotherboards;
    ArrayList<replacetempglass> replacetempglasses;
    mechanic(){
        this.replacetempglasses = new ArrayList<>();
        this.replacemotherboards = new ArrayList<>();
    }
    public void storefortempglassrepair(replacetempglass x){
        replacetempglasses.add(x);
    }
    public void storefortempglassrepair(replacemotherboard x){
        replacemotherboards.add(x);
    }
    public void getfortemprepair(){
        // get from arraylist replacetempglasses
    }
    public void getformotherboardrepair(){
        // get from arraylist replacemotherboards
    }
}
interface replacemotherboard{
    public void replacemotherboard(String x);
    public void shutdown();
}
interface replacetempglass{
    public void replacetemperedglass(String x);
    public void airplanemode();
}
class smartphone implements  replacetempglass {
    private boolean mobilenetwork;
    private String tempglass;
    smartphone(){
        mobilenetwork = true;
        tempglass = "default";
    }
    @Override
    public void replacetemperedglass(String x) {
        airplanemode();
        tempglass = x;
    }


    @Override
    public void airplanemode() {
        this.mobilenetwork = false;
    }
}
class tablet implements  replacetempglass, replacemotherboard {
    private boolean wifi;
    private String tempglass;
    private String motherboard;
    private boolean turnoff;
    tablet(){
        wifi = true;
        motherboard = "default";
        tempglass = "default";
        turnoff = false;
    }
    @Override
    public void replacemotherboard(String x) {
        shutdown();
        motherboard = x;
    }

    @Override
    public void replacetemperedglass(String x) {
        airplanemode();
        tempglass = x;
    }
    @Override
    public void shutdown() {
        turnoff = true;
    }

    @Override
    public void airplanemode() {
        this.wifi = false;
    }
}
class laptop implements  replacemotherboard {
    private boolean hibernate;
    private String motherboard;
    laptop(){
        this.hibernate = false;
        motherboard = "default";
    }

    @Override
    public void replacemotherboard(String x) {
        shutdown();
        motherboard = x;

    }

    @Override
    public void shutdown() {
        this.hibernate = true;
    }

}
