package com.microsoft.quantum.qlmsrequestservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "equipment_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_number", unique = true)
    private String requestNumber;

    @Column(name = "equipment_id")
    private Long equipmentId;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "requested_by")
    private String requestedBy;

    @Column(name = "researcher_email")
    private String researcherEmail;

    @Column(nullable = false)
    private String status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private String justification;
    private String priority;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "approved_at")
    private LocalDateTime approvedAt;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
        if (status == null) status = "PENDING";
        if (priority == null) priority = "NORMAL";
    }
}
