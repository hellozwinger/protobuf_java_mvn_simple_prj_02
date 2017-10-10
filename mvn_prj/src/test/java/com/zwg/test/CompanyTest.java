package  com.zwg.test;

import org.junit.Test;

import com.zwg.myprj.CompanyManagement;



public class CompanyTest {
    @Test
    public void Test() {
        try {
            String filepath=System.getenv("data_file");
            CompanyManagement.addDepart(filepath, "Oracle", 1);
            CompanyManagement.addDepart(filepath, "IBM", 2);
            CompanyManagement.addDepart(filepath, "CICO", 3);
            CompanyManagement.listAll(filepath);
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
            System.out.println("====> Fail to run CompanyTest!");
            return;
        }
        System.out.println("====> Success to run CompanyTest!"); 
    }
}
