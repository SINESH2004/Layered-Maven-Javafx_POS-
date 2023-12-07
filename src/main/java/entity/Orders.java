package entity;

import lombok.*;

@ToString@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class Orders {
    private String orderId;
    private String date;
    private String customerId;
}
