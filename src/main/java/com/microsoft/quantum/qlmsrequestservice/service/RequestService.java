package com.microsoft.quantum.qlmsrequestservice.service;

import com.microsoft.quantum.qlmsrequestservice.model.EquipmentRequest;
import com.microsoft.quantum.qlmsrequestservice.repository.EquipmentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RequestService {

    @Autowired
    private EquipmentRequestRepository repository;

    public List<EquipmentRequest> getAllRequests() {
        return repository.findAll();
    }

    public Optional<EquipmentRequest> getById(Long id) {
        return repository.findById(id);
    }

    public EquipmentRequest createRequest(EquipmentRequest request) {
        request.setRequestNumber("REQ-"
                + UUID.randomUUID().toString()
                .substring(0, 8).toUpperCase());
        return repository.save(request);
    }

    public EquipmentRequest approveRequest(Long id, String approvedBy) {
        EquipmentRequest request = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Request not found!"));
        request.setStatus("APPROVED");
        request.setApprovedBy(approvedBy);
        request.setApprovedAt(LocalDateTime.now());
        return repository.save(request);
    }

    public EquipmentRequest rejectRequest(Long id, String reason) {
        EquipmentRequest request = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Request not found!"));
        request.setStatus("REJECTED");
        request.setRejectionReason(reason);
        return repository.save(request);
    }

    public List<EquipmentRequest> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<EquipmentRequest> getMyRequests(String username) {
        return repository.findByRequestedBy(username);
    }
}
