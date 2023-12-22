package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class orderDetailsKey implements Serializable {

    @Column(name = "order_id",nullable = false)
    private String orderId;


    @Column(name = "product_code",nullable = false)
    private String productCode;
}
