package entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor@Setter
@Getter@ToString
@Entity
public class OrderDetail {
    @EmbeddedId
    private orderDetailsKey key;

    @ManyToOne
    @MapsId("productCode")
    @JoinColumn(name = "product_code")
    Products products;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Orders orders;

    private int qty;
    private double unitPrice;

}
