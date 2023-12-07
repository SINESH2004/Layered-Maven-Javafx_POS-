package entity;

import lombok.*;

@AllArgsConstructor@NoArgsConstructor@Setter@Getter@ToString
public class Products {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
