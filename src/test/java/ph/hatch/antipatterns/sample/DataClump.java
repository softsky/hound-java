package ph.hatch.antipatterns.sample;

public class DataClump {

    public void methodOne(String firstname, String lastname) {
        String tmp;

        tmp = firstname + lastname;

        if("".contentEquals(tmp)) {
            System.out.println("nothing here");
        }

    }
    public void methodTwo(String firstname, String lastname) { String tmp;}
    public void methodThree(String firstname1, String lastname1) {}
    public void methodFour(String firstname, String lastname, String firstname2, String lastname2) {}

}
