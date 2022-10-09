package com.trucking.service;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.truck.entity.Truck;
import com.truck.service.TruckService;

/**
 * Test the truck service for both predicted successes and failures. The service should be able to
 * handle both gracefully.
 * 
 * @author Erik Jepsen
 *
 */
public class TruckServiceTests {
  private TruckService truckService;
  private Truck truckA, truckB;

  /**
   * This initializes the service for testing. In testing, we use H2 for in-memory DB transactions.
   * In production, this will be handled by an AWS server running MySql.
   */
  @BeforeAll
  public void setupService() {
    truckService = new TruckService();
    truckA = new Truck(1, "Pontiac", "Fiero", 1986);
    truckB = new Truck(2, "AMC", "Hornet", 1976);
  }

  /**
   * Given a new truck<br/>
   * Action requested ** Add truck to DB.<br/>
   * Expected result ** (int) 1 (indicating 1 record added.)<br/>
   */
  @Test
  public void givenANewTruck_ServiceAddsTruck_ServiceSuccessfullyAddsTruck() {
    try {
      Assert.assertEquals(1, truckService.add(truckA));
    } catch (Exception e) {
      System.err.println(e.getMessage());
      Assert.fail("The service threw an exception.");
    }
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Add truck to DB.<br/>
   * Expected result ** (int) 0 (indicating 0 records were added.)
   */
  @Test
  public void givenExistingTruck_ServiceAddTruck_ServiceDoesntAddTruck() {
    truckService.add(truckA);
    Assert.assertNotEquals(1, truckService.add(truckA));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Delete the truck.<br/>
   * Expected result ** (bool) true (indicating the truck was deleted)
   */
  @Test
  public void givenDeleteExistingTruck_ServiceDeletesTruck_ReturnsTrue() {
    truckService.add(truckA);
    Assert.assertTrue(truckService.remove(truckA));
  }

  /**
   * Given a nonexistent truck<br/>
   * Action requested ** Delete the truck<br/>
   * Expected result ** (bool) false (indicating the truck was not deleted)
   */
  @Test
  public void givenDeleteAbsentTruck_ServiceDeletesTruck_ReturnsFalse() {
    Assert.assertFalse(truckService.remove(truckA));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Find the truck<br/>
   * Expected result ** (Truck) truck (Returns the truck sought)
   */
  @Test
  public void givenExistingTruck_ServiceFindTruck_ReturnsTruck() {
    truckService.add(truckA);
    Assert.assertEquals(truckA, truckService.find(truckA));
  }

  /**
   * Given a nonexistent truck<br/>
   * Action requested ** Find the truck<br/>
   * Expected result ** Null (Truck sought isn't in the DB)
   */
  @Test
  public void givenNonexistentTruck_ServiceFindTruck_ReturnNull() {
    Assert.assertNull(truckService.find(truckA));
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
