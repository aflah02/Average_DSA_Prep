public class ooptester {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.print("A");
        }
        catch (Exception ex) {
            System.out.print("B");
        }
        finally {
            System.out.print("C");
        }
        System.out.print("D");
    }
    public static void badMethod() throws Exception {
        throw new Exception(); /* Line 22 */
    }
    }
