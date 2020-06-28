package uk.co.asto.interview.cats.adapter.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.asto.interview.cats.adapter.api.model.dto.FactDTO;
import uk.co.asto.interview.cats.port.core.FactService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/facts")
public class FactController {
    private final FactService factService;

    @Autowired
    public FactController(final FactService factService) {
        this.factService = factService;
    }

    @GetMapping
    public ResponseEntity<List<FactDTO>> getCatFacts(@RequestParam(value = "q") Optional<String> q) {
        return  factService.findFacts(q).stream()
                .map(fact -> FactDTO.builder().fact(fact.getFact()).build())
                .collect(Collectors.collectingAndThen(Collectors.toList(), factDTOs -> ResponseEntity.ok().body(factDTOs)));
    }
}
