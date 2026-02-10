package com.flames.controller;

import com.flames.model.FlamesRequest;
import com.flames.model.FlamesResponse;
import com.flames.service.FlamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/flames")
@CrossOrigin(origins = "*")
public class FlamesController {

  private final FlamesService flamesService;

  public FlamesController(FlamesService flamesService) {
    this.flamesService = flamesService;
  }

  @PostMapping
  public ResponseEntity<FlamesResponse> calculate(@RequestBody FlamesRequest req) {
    if (req == null || (isEmpty(req.getMale()) && isEmpty(req.getFemale()))) {
      return ResponseEntity.badRequest().build();
    }

    Map<String, String> result = flamesService.calculate(req.getMale(), req.getFemale());
    FlamesResponse resp = new FlamesResponse(result.get("result"), result.get("meaning"),
        "/images/" + result.get("image"));
    return ResponseEntity.ok(resp);
  }

  private boolean isEmpty(String s) {
    return s == null || s.trim().isEmpty();
  }
}