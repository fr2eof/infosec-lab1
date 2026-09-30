package se.ifmo.ru.lab1.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import se.ifmo.ru.lab1.dto.DataRequest;
import se.ifmo.ru.lab1.dto.DataResponse;
import se.ifmo.ru.lab1.model.UserData;
import se.ifmo.ru.lab1.service.UserDataService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class UserDataController {
    private final UserDataService userDataService;

    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping
    public ResponseEntity<List<DataResponse>> getData() {
        List<DataResponse> result = userDataService.getAllData();

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> createData(
            @Valid @RequestBody DataRequest request,
            Authentication authentication
    ) {
        UserData data = userDataService.createData(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Map.of(
                        "message", "Data created",
                        "id", data.getId(),
                        "title", data.getTitle(),
                        "content", data.getContent()
                )
        );
    }
}
