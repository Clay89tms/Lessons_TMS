package org.example.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.Address;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Property {

    private String car;
    private String house;
    private String computer;
//    @Embedded
//    private Address address;
}
