package br.com.rhfactor.nasaneoapi.controllers;

import br.com.rhfactor.nasaneoapi.dtos.PotentiallyHazardousAsteroid;
import br.com.rhfactor.nasaneoapi.services.NasaRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(PotentiallyHazardousAsteroidController.PATH)
public class PotentiallyHazardousAsteroidController {

    public static final String PATH = "/api/v1/potentially-hazardous-asteroid";

    @Autowired
    private NasaRequestService nasaRequestService;

    // TODO: No erro deve retornar 400 está retornando 500
    @GetMapping("{date}")
    public List<PotentiallyHazardousAsteroid> getPotentiallyHazardousAsteroidController(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") @NotNull LocalDate selectedDate) throws JsonProcessingException {
        // Deve retornar 404 se não houver
        log.info("Requesting for date {}", selectedDate);
        return nasaRequestService.getListOfPotentiallyHazardousAsteroid(selectedDate);
    }

}
