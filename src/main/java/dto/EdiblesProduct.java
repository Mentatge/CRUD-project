package dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EdiblesProduct implements Product {
    private String  name;
    private int cost;
    private int count;
    private double weight;
}

