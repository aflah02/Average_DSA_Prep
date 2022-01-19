interface Storage{
    public void storagetype();
}

class Phone implements Storage{

    @Override
    public void storagetype() {
        System.out.println("SD Card");
    }
}

public class iPhone extends Phone implements Storage{
    public static void main(String[] args) {
        Storage S = new iPhone();
        Phone P = new iPhone();
        S.storagetype();
        P.storagetype();
    }
}
