package task3;

public class TestClass implements TestInterface {

    private int privateTestIntField;
    public int publicTestIntField;
    private String privateTestStringField;
    public String[] publicTestStringArrayField;

    public TestClass(int privateTestIntField, int publicTestIntField, String privateTestStringField, String[] publicTestStringArrayField) {
        this.privateTestIntField = privateTestIntField;
        this.publicTestIntField = publicTestIntField;
        this.privateTestStringField = privateTestStringField;
        this.publicTestStringArrayField = publicTestStringArrayField;
    }

    public TestClass() {
        this(0, 1, "Hello", new String[]{"Hello", "world!"});
    }

    private int privateTestMethod() {
        return 0;
    }

    public void publicTestMethod() {
    }

    @Override
    public void testInterfaceMethod() {
    }

    public Integer fakeInsert(Integer number) {
        return null;
    }

    public int getPrivateTestIntField() {
        return privateTestIntField;
    }

    public int getPublicTestIntField() {
        return publicTestIntField;
    }

    public String getPrivateTestStringField() {
        return privateTestStringField;
    }

    public String[] getPublicTestStringArrayField() {
        return publicTestStringArrayField;
    }
}
