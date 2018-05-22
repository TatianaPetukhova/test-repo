package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBaseClass {
    private long initTime;

    @BeforeSuite
    public void beforeSuite() {
        initTime = System.currentTimeMillis();
        // e.g. initialize a lot of ...
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Suite time is: " + (System.currentTimeMillis() - initTime));
    }

    //@Test(enabled = false)
    //@Test(groups = {"smoke", "regression"})

    //@Test(dependsONMethod = "loginTest") такое нельзя делать!!!!!!!
    //@Test(dependsOnGroups = "init.*")

    //@Test(threadPoolSize = 3, invocationCount = 10, timeOut = 1000) очень полезная штука
    //второе - сколько раз хотим запусить
    // первое - во сколько потоков распараллелить
    // третье - задержка перед запуском

}
