package com.truck.service;

import java.util.Optional;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.truck.entity.Truck;
import com.truck.repo.TruckRepo;

/**
 * Test the truck service for both predicted successes and failures. The service should be able to
 * handle both gracefully.
 * 
 * Credit to barnfinds.com and davidsclassiccars.com for their respective photos.
 * 
 * @author Erik Jepsen
 *
 */
@RunWith(SpringRunner.class)
public class TruckServiceTests {

  @TestConfiguration
  static class TruckServiceImplTestContextConfig {
    @Bean
    public TruckService truckService() {
      return new TruckService();
    }
  }

  @Autowired
  private TruckService truckService;
  @MockBean
  private TruckRepo truckRepo;
  private Truck truckA = new Truck("AMC", "Hornet", 1976);
  private Truck truckB = new Truck("Pontiac", "Fiero", 1986);

  @Before
  public void setup() {
    Mockito.when(truckRepo.findById(1)).thenReturn(Optional.of(truckA));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Add truck to DB.<br/>
   * Expected result ** (int) 0 (indicating 0 records were added.)
   */
  @Test
  public void givenExistingTruck_ServiceAddTruck_ServiceDoesntAddTruck() {
    truckService.add(truckA);
    Assertions.assertEquals(0, truckService.add(truckA));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Delete the truck.<br/>
   * Expected result ** (bool) true (indicating the truck was deleted)
   */
  @Test
  public void givenDeleteExistingTruck_ServiceDeletesTruck_ReturnsTrue() {
    truckService.add(truckA);
    Assertions.assertTrue(truckService.remove(truckA));
  }

  /**
   * Given a nonexistent truck<br/>
   * Action requested ** Delete the truck<br/>
   * Expected result ** (bool) false (indicating the truck was not deleted)
   */
  @Test
  public void givenDeleteAbsentTruck_ServiceDeletesTruck_ReturnsFalse() {
    Assertions.assertFalse(truckService.remove(truckA));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Find the truck<br/>
   * Expected result ** (Truck) truck (Returns the truck sought)
   */
  @Test
  public void givenExistingTruck_ServiceFindTruck_ReturnsTruck() {
    truckService.add(truckA);
    Assertions.assertEquals(truckA, truckService.find(1));
  }

  /**
   * Given a nonexistent truck<br/>
   * Action requested ** Find the truck<br/>
   * Expected result ** Null (Truck sought isn't in the DB)
   */
  @Test
  public void givenNonexistentTruck_ServiceFindTruck_ReturnNull() {
    Assertions.assertNull(truckService.find(1));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Update from truckA to truckB<br/>
   * Expected result ** (int) 1 (indicating one record altered)
   */
  @Test
  public void givenExistingTruck_ServiceUpdateTruckFromAtoB_ReturnOne() {
    truckService.add(truckA);
    Assertions.assertEquals(1, truckService.update(1, truckB));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Update from truckA to truckB then find truck record 1<br/>
   * Expected result ** (bool) true (TruckB == record 1)
   */
  @Test
  public void givenExistingTruck_ServiceUpdateTruckFromAtoB_ReturnTruckB() {
    truckService.add(truckA);
    truckService.update(1, truckB);
    Assertions.assertEquals(truckB, truckService.find(1));
  }

  /**
   * Given a nonexistent truck<br/>
   * Action requested ** Update from truckA to truckB<br/>
   * Expected result ** (int) 0 (indicating one record altered)
   */
  @Test
  public void givenExistingTruck_ServiceUpdateTruckFromAtoB_ReturnZero() {
    Assertions.assertEquals(0, truckService.update(1, truckB));
  }

  /**
   * After each test, if a test object is still in the DB, remove it.
   */
  @AfterEach
  public void removeTestObjectsFromDB() {
    if (truckService.find(truckA) != null)
      truckService.remove(truckA);
    if (truckService.find(truckB) != null)
      truckService.remove(truckB);
  }

}
