import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//importing the libs
public class loadZooDetailsTest{
    private Zoo zoo;
    @BeforeEach
    public void setUp() {
        zoo = new Zoo();
    }//end of setting up
    @Test
        void loadZooDetails_populatesZooFields() {
            //checking for null values.
        zoo.setZooName("Zoo Ulster");
        zoo.setAddress("2 CarnFire Way");
        zoo.setPostcode("BT36 5UP");
        zoo.setTelephone("07245 28392");
        //setting my values for tesing
        //setting my values for tesing
        zoo.saveZooDetails();
        //saving the zoo details
        Zoo testZoo = new Zoo();
        //creating zoo testing instance
        testZoo.loadZooDetails();
        //laoding the new zoo details in instance
        //Checking is answer equals input
        assertEquals("Zoo Ulster", testZoo.getZooName());
        assertEquals("2 CarnFire Way", testZoo.getAddress());
        assertEquals("BT36 5UP", testZoo.getPostcode());
        assertEquals("07245 28392", testZoo.getTelephone());
        //checking if not null
        assertNotNull(testZoo.getZooName());
        assertNotNull(testZoo.getAddress());
        assertNotNull(testZoo.getTelephone());
        assertNotNull(testZoo.getPostcode());
        }//end of checking for nulls
    //testing to see if the zoo details are loaded correctly.
}//end of real test