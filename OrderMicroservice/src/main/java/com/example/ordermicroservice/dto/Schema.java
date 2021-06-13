package com.example.ordermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Schema {
   private String type;
   private List<Field> fields;
   private boolean optional;
   private String name;
}
