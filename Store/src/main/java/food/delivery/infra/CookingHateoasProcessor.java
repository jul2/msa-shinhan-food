package food.delivery.infra;
import food.delivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class CookingHateoasProcessor implements RepresentationModelProcessor<EntityModel<Cooking>>  {

    @Override
    public EntityModel<Cooking> process(EntityModel<Cooking> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/accept-reject").withRel("accept-reject"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/cookfinish").withRel("cookfinish"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/cookstart").withRel("cookstart"));

        
        return model;
    }
    
}
