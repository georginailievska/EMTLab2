package mk.ukim.finki.airbnb.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.airbnb.dto.CreateHostDto;
import mk.ukim.finki.airbnb.dto.DisplayHostDto;
import mk.ukim.finki.airbnb.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostApplicationService hostService;

    public HostController(HostApplicationService hostService) {
        this.hostService = hostService;
    }

    @Operation(summary = "Get all hosts", description = "Returns a list of all hosts.")
    @GetMapping
    public ResponseEntity<List<DisplayHostDto>> getAll() {
        return ResponseEntity.ok(hostService.getAll());
    }

    @Operation(summary = "Get host by ID")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(hostService.getById(id));
    }

    @Operation(summary = "Create a new host")
    @PostMapping
    public ResponseEntity<DisplayHostDto> create(@RequestBody CreateHostDto dto) {
        return ResponseEntity.ok(hostService.create(dto));
    }

    @Operation(summary = "Update host")
    @PutMapping("/{id}")
    public ResponseEntity<DisplayHostDto> update(@PathVariable Long id, @RequestBody CreateHostDto dto) {
        return ResponseEntity.ok(hostService.update(id, dto));
    }

    @Operation(summary = "Delete host")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hostService.delete(id);
        return ResponseEntity.ok().build();
    }
}
