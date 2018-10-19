package za.co.telkom.managercustomerms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(value = "/api/fruits")
public class FruitController {

  private final FruitRepository repository;

  @Autowired
  public FruitController(FruitRepository repository) {
    this.repository = repository;
  }

  @ResponseBody
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List getAll() {
    return StreamSupport
      .stream(repository.findAll().spliterator(), false)
      .collect(Collectors.toList());
  }

//TODO: Add additional service calls here
}
