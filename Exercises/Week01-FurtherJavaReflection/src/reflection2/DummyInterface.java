package reflection2;

/**
 * Created by nathanhanak on 2/3/17.
 */
public interface DummyInterface {

    public String getPrivateStringField();

    public int getPrivateIntField();

    public void setPrivateStringField(String s);

    public void setPrivateIntField(int i);

    /**
     * Method which modifies the public double field by calling
     * a private method and then returns the modified field
     * @return Double the amount of the publicDouble field after its modfication.
     */
    public Double getAndModifyPublicDoubleField();

    public void printAllMemberFields();

}
