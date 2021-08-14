package Resource;

import Domain.signup;
import Repository.signupRepo;

import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("getall")
public class signupResource {
    signupRepo repo = new signupRepo();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<signup>getStudent(){
        return repo.getSignUp();
    }

    @POST
    @Path("set")
    @Consumes({MediaType.APPLICATION_JSON})
    public signup createStudent(signup signup){
        return repo.createStudent(signup);
    }

}
