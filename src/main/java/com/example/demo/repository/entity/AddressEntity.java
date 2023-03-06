package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Table(name = "address")
@Entity
public class AddressEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String streetName;
    @Column
    private String buildNumber;
}
