package com.gdg.canteen.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    @DecimalMax(value = "99999.99", message = "Price must not exceed 99999.99")
    private Double price;

    @NotBlank(message = "Category cannot be blank")
    @Size(max = 50, message = "Category must not exceed 50 characters")
    private String category;

    @NotNull(message = "Availability status is required")
    private Boolean availability;
}