package br.com.dmopen.customer.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
@Table("customer")
public class Customer {

    @Id
    private UUID uuid;

    private String name;

    private String status;

    @CreatedDate
    private LocalDateTime created;

}
