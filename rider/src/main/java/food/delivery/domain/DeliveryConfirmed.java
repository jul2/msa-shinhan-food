package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryConfirmed extends AbstractEvent {

    private Long id;
    private String orderId;

    public DeliveryConfirmed(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryConfirmed(){
        super();
    }
}
