package com.truck.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.truck.entity.Truck;
import com.truck.service.TruckService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TruckController.class)
public class TruckControllerTests {
  @MockBean
  private TruckService service;

  @Autowired
  private MockMvc mvc;

  private final Truck truckA = new Truck(-1, "AMC", "Hornet", 1976);
  // private final Truck truckB = new Truck("Pontiac", "Fiero", 1986);

  @Test
  @SuppressWarnings("unchecked")
  public void givenValidTruck_WhenGetTrucks_ThenReturnJsonArray() throws Exception {
    given(service.getAllTrucksExt(Collections.EMPTY_MAP))
        .willReturn(Collections.singletonList(truckA));
    mvc.perform(get("/api/v1/truck/").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$[0].model", is(truckA.getModel())))
        .andExpect(jsonPath("$", hasSize(1)));
    Mockito.reset(service);
  }

  @Test
  public void givenValidTruck_WhenGetTruckById_ReturnTruck() throws Exception {
    given(service.getTruckById(12)).willReturn(truckA);
    mvc.perform(get("/api/v1/truck/12").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("model", is(truckA.getModel())))
        .andExpect(jsonPath("make", is(truckA.getMake())));
    Mockito.reset(service);
  }

  @Test
  public void GivenInvalidTruck_WhenGetTruckById_ThrowsException() throws Exception {
    given(service.getTruckById(12)).willThrow(RuntimeException.class);
    mvc.perform(get("/api/v1/truck/12").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
    Mockito.reset(service);
  }

  @Test
  public void GivenValidMake_WhenGetTruckByMake_ReturnTruck() throws Exception {
    given(service.getAllTrucksConditional(0, "AMC")).willReturn(Collections.singletonList(truckA));
    mvc.perform(get("/api/v1/truck/make/AMC")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].model", is(truckA.getModel())));
    Mockito.reset(service);
  }

  @Test
  public void GivenAbsentMake_WhenGetTruckByMake_ReturnEmptyArray() throws Exception {
    given(service.getAllTrucksConditional(0, "BMC")).willReturn(new ArrayList<Truck>());
    mvc.perform(get("/api/v1/truck/make/BMC")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
    Mockito.reset(service);
  }

  @Test
  public void GivenValidModel_WhenGetTruckByModel_ReturnTruck() throws Exception {
    given(service.getAllTrucksConditional(1, "Hornet"))
        .willReturn(Collections.singletonList(truckA));
    mvc.perform(get("/api/v1/truck/model/Hornet")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].make", is(truckA.getMake())));
    Mockito.reset(service);
  }

  @Test
  public void GivenAbsentModel_WhenGetTruckByModel_ReturnEmptyArray() throws Exception {
    given(service.getAllTrucksConditional(1, "Wasp")).willReturn(new ArrayList<Truck>());
    mvc.perform(get("/api/v1/truck/model/Wasp")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
    Mockito.reset(service);
  }

  @Test
  public void GivenValidYear_WhenGetTrucksByYear_ReturnTrucks() throws Exception {
    given(service.getAllTrucksConditional(2, "1976")).willReturn(Collections.singletonList(truckA));
    mvc.perform(get("/api/v1/truck/year/1976")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].year", is(1976)));
  }

  @Test
  @SuppressWarnings("unchecked")
  public void GivenInvalidYear_WhenGetTruckByYear_ReturnsEmptyArray() throws Exception {
    given(service.getAllTrucksConditional(2, "1900")).willReturn(Collections.EMPTY_LIST);
    mvc.perform(get("/api/v1/truck/year/1900")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
  }
}
