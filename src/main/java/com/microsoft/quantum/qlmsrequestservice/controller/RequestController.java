
package com.microsoft.quantum.qlmsrequestservice.controller;

import com.microsoft.quantum.qlmsrequestservice.model.EquipmentRequest;
import com.microsoft.quantum.qlmsrequestservice.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<EquipmentRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentRequest> getById(
            @PathVariable Long id) {
        return requestService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EquipmentRequest createRequest(
            @RequestBody EquipmentRequest request) {
        return requestService.createRequest(request);
    }

    @PutMapping("/{id}/approve")
    public EquipmentRequest approveRequest(
            @PathVariable Long id,
            @RequestParam String approvedBy) {
        return requestService.approveRequest(id, approvedBy);
    }

    @PutMapping("/{id}/reject")
    public EquipmentRequest rejectRequest(
            @PathVariable Long id,
            @RequestParam String reason) {
        return requestService.rejectRequest(id, reason);
    }

    @GetMapping("/status/{status}")
    public List<EquipmentRequest> getByStatus(
            @PathVariable String status) {
        return requestService.getByStatus(status);
    }

    @GetMapping("/my/{username}")
    public List<EquipmentRequest> getMyRequests(
            @PathVariable String username) {
        return requestService.getMyRequests(username);
    }
}