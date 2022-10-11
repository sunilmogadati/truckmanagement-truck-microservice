package com.truck.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.truck.entity.Truck;
import com.truck.service.TruckService;

@RunWith(SpringRunner.class)
@WebMvcTest(TruckController.class)
public class TruckControllerTests {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private TruckService service;

  private Truck truckA = new Truck("AMC", "Hornet", 1976);
  private Truck truckB = new Truck("Pontiac", "Fiero", 1986);

  @Test
  public void givenValidTruck_WhenGetTrucks_ThenReturnJsonArray() throws Exception {
    List<Truck> allTrucks = Arrays.asList(truckA);
    BDDMockito.given(service.getAllTrucks()).willReturn(allTrucks);
    mvc.perform(get("/api/v1/truck").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].model", is(truckA.getModel())));
  }

  @Test
  public void givenValidTruck_WhenGetTruckById_ReturnTruck() {
    BDDMockito.given(service.getTruckById(Matchers.any(int.class))).willReturn(truckA);
    mvc.perform(get("api/v1/truck/12").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].model", is(truckA.getModel())));
  }

  @Test
  public void GivenInvalidTruck_WhenGetTruckById_ThrowsException() {
    BDDMockito.given(service.getTruckById(Matchers.any(int.class)))
        .willThrow(RuntimeException.class);
    mvc.perform(get("/api/v1/truck/12").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  public void GivenValidMake_WhenGetTruckByMake_ReturnTruck() {
    BDDMockito.given(service.getAllTrucksConditional(0, Matchers.any(String.class)))
        .willReturn(Arrays.asList(truckA));
    mvc.perform(get("/api/v1/truck/make/AMC")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].model", is(truckA.getModel())));
  }

  @Test
  public void GivenAbsentMake_WhenGetTruckByMake_ReturnEmptyArray() {
    BDDMockito.given(service.getAllTrucksConditional(0, Matchers.any(String.class)))
        .willReturn(new ArrayList<Truck>());
    mvc.perform(get("/api/v1/truck/make/BMC")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
  }

  @Test
  public void GivenValidModel_WhenGetTruckByModel_ReturnTruck() {
    BDDMockito.given(service.getAllTrucksConditional(1, Matchers.any(String.class)))
        .willReturn(Arrays.asList(truckA));
    mvc.perform(get("/api/v1/truck/model/Hornet")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].make", is(truckA.getMake())));
  }

  @Test
  public void GivenAbsentModel_WhenGetTruckByModel_ReturnEmptyArray() {
    BDDMockito.given(service.getAllTrucksConditional(1, Matchers.any(String.class)))
        .willReturn(new ArrayList<Truck>());
    mvc.perform(get("/api/v1/truck/model/Wasp")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
  }

}
