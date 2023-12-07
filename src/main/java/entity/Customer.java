package entity;
import lombok.*;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private String id;
    private String name;
    private String address;
    private double salary;
}
