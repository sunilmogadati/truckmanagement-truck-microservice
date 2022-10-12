package com.truck.service;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Answer1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
@ExtendWith(SpringExtension.class)
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

  private final Truck truckA = new Truck(1, "AMC", "Hornet", 1976);
  private final Truck truckB = new Truck(1, "Pontiac", "Fiero", 1986);


  /**
   * Given an existing truck<br/>
   * Action requested ** Delete the truck.<br/>
   * Expected result ** (bool) true (indicating the truck was deleted)
   */
  @Test
  public void givenDeleteExistingTruck_ServiceDeletesTruck_ReturnsNullWhenSearched() {
    // Given
    Mockito.when(truckRepo.findById(1)).thenReturn(Optional.of(truckA));
    Answer<Integer> ans = new Answer<Integer>() {
      @Override
      public Integer answer(InvocationOnMock invocation) throws Throwable {
        Mockito.when(truckRepo.findById(1)).thenReturn(Optional.empty());
        return 0;
      }
    };
    Mockito.lenient().doAnswer(ans).when(truckRepo).delete(truckA);
    Truck inTruck = truckService.addTruck(truckA);

    //When
    truckService.deleteTruck(1);

    //Assert
    Assertions.assertThrows(RuntimeException.class, () -> truckService.getTruckById(1));
  }

  /**
   * Given a nonexistent truck<br/>
   * Action requested ** Delete the truck<br/>
   * Expected result ** (Exception) RuntimeException: Truck wasn't found.
   */
  @Test
  public void givenDeleteAbsentTruck_ServiceDeletesTruck_ThrowsException() {
    Assertions.assertThrows(RuntimeException.class, () -> truckService.deleteTruck(Integer.MAX_VALUE));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Find the truck<br/>
   * Expected result ** (Truck) truck (Returns the truck sought)
   */
  @Test
  public void givenExistingTruck_ServiceFindTruck_ReturnsTruck() {
    Mockito.when(truckRepo.save(truckA)).thenReturn(truckA);
    Mockito.when(truckRepo.findById(1)).thenReturn(Optional.of(truckA));
    Truck inTruck = truckService.addTruck(truckA);
    Assertions.assertEquals(inTruck, truckService.getTruckById(inTruck.getId()));
  }

  /**
   * Given a nonexistent truck<br/>
   * Action requested ** Find the truck<br/>
   * Expected result ** Null (Truck sought isn't in the DB)
   */
  @Test
  public void givenNonexistentTruck_ServiceFindTruck_ThrowsException() {
    Assertions.assertThrows(RuntimeException.class,
      () -> truckService.getTruckById(Integer.MAX_VALUE));
  }

  /**
   * Given an existing truck<br/>
   * Action requested ** Update from truckA to truckB<br/>
   * Expected result ** (int) 1 (indicating one record altered)
  @Ignore
  public void givenExistingTruck_ServiceUpdateTruckFromAtoB_ReturnOne() {
    Truck inTruck = truckService.addTruck(truckA);
    Assertions.assertEquals(inTruck.getId(), truckService.update(inTruck.getId(), truckB));
  }
   */

  /**
   * Given an existing truck<br/>
   * Action requested ** Update from truckA to truckB then find truck record 1<br/>
   * Expected result ** (bool) true (TruckB == truckService.FindTruckById(TruckA.getId()))
  @Test
  public void givenExistingTruck_ServiceUpdateTruckFromAtoB_ReturnTruckB() {
    Truck inTruck = truckService.addTruck(truckA);
    Truck updatedTruck = truckService.updateTruck(inTruck.getId(), truckB);
    Assertions.assertEquals(updatedTruck, truckService.getTruckById(inTruck.getId()));
  }
   */

  /**
   * Given a nonexistent truck<br/>
   * Action requested ** Update from truckA to truckB<br/>
   * Expected result ** (int) 0 (indicating one record altered)
  @Test
  public void givenExistingTruck_ServiceUpdateTruckFromAtoB_ReturnZero() {
    Assertions.assertEquals(0, truckService.update(1, truckB));
  }
   */

  /**
   * After each test, if a test object is still in the DB, remove it.
   */
  @AfterEach
  public void removeTestObjectsFromDB() {
    for (Truck thisTruck: truckService.getAllTrucksConditional(0, "AMC"))
      truckService.deleteTruck(thisTruck.getId());
    for (Truck thisTruck: truckService.getAllTrucksConditional(0, "Pontiac"))
      truckService.deleteTruck(thisTruck.getId());
  }

}
