package com.microsoft.quantum.qlmsrequestservice.repository;

import com.microsoft.quantum.qlmsrequestservice.model.EquipmentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquipmentRequestRepository
        extends JpaRepository<EquipmentRequest, Long> {

    List<EquipmentRequest> findByStatus(String status);
    List<EquipmentRequest> findByRequestedBy(String requestedBy);
    List<EquipmentRequest> findByEquipmentId(Long equipmentId);
}