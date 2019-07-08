import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserClassTest {

    @Test
    public void whenSetCityInUserThenMethodReturnsSameCity() {
        //arrange
        String cityName = "Madrid";
        UserClass user = new UserClass();

        //act
        String cityReturned = user.setCity(cityName);

        //assert
        assertEquals(cityName, cityReturned);
    }

    @Test
    public void getCity() {
    }
}