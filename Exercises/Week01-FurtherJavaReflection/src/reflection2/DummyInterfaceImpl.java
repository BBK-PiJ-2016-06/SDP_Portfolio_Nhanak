package reflection2;

/**
 * Created by nathanhanak on 2/3/17.
 */
public class DummyInterfaceImpl implements DummyInterface {

    private String privStringField;
    private int privIntField = 6;
    public Double pubDoub = 2.5;

    public DummyInterfaceImpl(String s) {
        this.privStringField = s;
    }

    public DummyInterfaceImpl(String s, String s2) {
        privStringField = s;
        privStringField += s2;
    }

    @Override
    public String getPrivateStringField() {
        return this.privStringField;
    }

    @Override
    public int getPrivateIntField() throws IllegalAccessError {
        return this.privIntField;
    }

    @Override
    public void setPrivateStringField(String s) {
        privStringField = s;
    }

    @Override
    public void setPrivateIntField(int i) {
        privIntField = i;
    }

    @Override
    public Double getAndModifyPublicDoubleField() {
        modifyPubDoub();
        return pubDoub;
    }

    private void modifyPubDoub() {
        pubDoub += 2.0;
    }

    @Override
    public void printAllMemberFields(){
        System.out.println("privateStringfield= " + privStringField);
        System.out.println("privateIntField= " + privIntField);
        System.out.println("pubDoub= " + pubDoub);
    }


}
