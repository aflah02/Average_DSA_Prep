class Parent {
    private String name = "Parent";

    public String getParentName() {
        return name;
    }
}

public class Child extends Parent implements Cloneable{
    private String name = "Child";
    public String getName() {
        return name;
    }
    public Child clone() throws CloneNotSupportedException{
        return (Child) super.clone();
    }

    public static void main(String [] args)throws CloneNotSupportedException{
        Child C1 = new Child();
        Parent P2 = C1.clone();
        System.out.println(C1.getName()+P2.getParentName());
    }
}