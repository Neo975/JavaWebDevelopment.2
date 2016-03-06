package resources;

/**
 * Created by Mike on 05.03.2016.
 */
public class TestResourceController implements TestResourceControllerMBean {
    private TestResource testResource;

    public TestResourceController(TestResource testResource) {
        this.testResource = testResource;
    }

    public void setTestResource(TestResource testResource) {
        this.testResource = testResource;
    }

    @Override
    public int getAge() {
        return testResource.getAge();
    }

    @Override
    public String getName() {
        return testResource.getName();
    }
}
