package food.delivery.domain;

import food.delivery.domain.CookStarted;
import food.delivery.domain.Rejected;
import food.delivery.domain.CookFinished;
import food.delivery.domain.Accepted;
import food.delivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Cooking_table")
@Data

public class Cooking  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String add;

    @PostPersist
    public void onPostPersist(){


        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();



        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();

        // Get request from Cooking
        //food.delivery.external.Cooking cooking =
        //    Application.applicationContext.getBean(food.delivery.external.CookingService.class)
        //    .getCooking(/** mapping value needed */);

    }

    public static CookingRepository repository(){
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(CookingRepository.class);
        return cookingRepository;
    }



    public void acceptOrReject(){
    }
    public void cookFinish(){
    }
    public void cookStart(){
    }

    public static void loadOrderInfo(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

        
    }


}
