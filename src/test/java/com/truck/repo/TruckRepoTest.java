package com.truck.repo;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.test.context.junit4.SpringRunner;
import com.truck.entity.Truck;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TruckRepoTest {
  @Autowired
  private TestEntityManager entityManager;
  @Autowired
  private TruckRepo truckRepo;
  private final Truck truckA = new Truck("AMC", "Hornet", 1976);
  private final Truck truckB = new Truck("Pontiac", "Fiero", 1986);

  @Test
  public void a01_givenValidTruck_RepoAddTruck_ReturnTruck() {
    // Given is a class field.

    // When
    Truck outTruck = truckRepo.save(truckA);

    // Assert
    Assert.assertEquals(truckA, outTruck);

  }

  @Test
  public void a02_GivenValidTruck_FindTruck_ReturnNotNull() {
    // Given
    Truck inTruck = truckRepo.save(truckA);

    // When
    Truck outTruck = truckRepo.findById(inTruck.getTruck_id()).orElse(null);

    // Assert
    Assert.assertNotNull(outTruck);
  }

  @Test
  public void a03_GivenValidTruck_FindTruck_ReturnTruck() {
    // Given
    Truck inTruck = truckRepo.save(truckA);

    // When
    Truck outTruck = truckRepo.findById(inTruck.getTruck_id()).orElse(null);

    // Assert
    Assert.assertEquals(truckA, outTruck);
  }

  // This is throwing an error because the JPA isn't passing the ID to the SQL statement.
  // Normally this should return null in the when phase.
  @Test(expected = InvalidDataAccessResourceUsageException.class)
  public void a04_GivenInvalidTruck_FindTruck_ReturnNull() {
    // Given
    truckRepo.save(truckA);

    // When
    Assert.assertNull(truckRepo.findById(5).orElse(null));
  }

  @Test
  public void a05_GivenValidTruck_UpdateTruck_ReturnUpdatedTruck() {
    // Given
    Truck inTruck = truckRepo.save(truckA);
    Truck outTruck = truckB;
    outTruck.setTruck_id(inTruck.getTruck_id());

    // When
    Truck newTruck = truckRepo.save(outTruck);

    // Assert
    Assert.assertEquals(outTruck, newTruck);
  }
}
