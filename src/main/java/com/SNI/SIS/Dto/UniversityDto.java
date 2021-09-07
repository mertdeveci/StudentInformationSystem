package com.SNI.SIS.Dto;

import com.SNI.SIS.Entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {

    private String name;

    private AddressDto address;
}
