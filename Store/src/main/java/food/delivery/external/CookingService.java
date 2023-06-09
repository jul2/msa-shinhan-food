package food.delivery.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "Store", url = "${api.url.Store}")
public interface CookingService {
    @RequestMapping(method= RequestMethod.GET, path="/cookings/{id}")
    public Cooking getCooking(@PathVariable("id") Long id);
}
