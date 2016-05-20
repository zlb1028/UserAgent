package hello.controller;

import hello.entity.UserAgentEntity;
import hello.object.UserAgentObject;
import hello.object.UserAgentStringObject;
import hello.repository.UserAgentRepository;
import hello.service.UserAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yunsu on 2016/5/19.
 */
@RestController
@RequestMapping("/useragent")
public class UserAgentController {

    @Autowired
    private UserAgentService userAgentService;

    @Autowired
    private UserAgentRepository userAgentRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserAgentObject create(@RequestBody UserAgentStringObject userAgentStringObject) {
        String userAgentString=userAgentStringObject.getString();
        UserAgentObject userAgentObject=userAgentService.getUserAgentByString(userAgentString);
//        return userAgentObject;
        UserAgentEntity entity=toUserAgentEntity(userAgentObject);
        return toUserAgentObject(userAgentRepository.save(entity));
    }

    private UserAgentEntity toUserAgentEntity(UserAgentObject object){
        if (object == null) {
            return null;
        }
        UserAgentEntity entity=new UserAgentEntity();
        entity.setOs(object.getOs());
        entity.setBrowser(object.getBrowser());
        entity.setApp(object.getApp());
        entity.setNetType(object.getNetType());
        return entity;
    }


    private UserAgentObject toUserAgentObject(UserAgentEntity entity) {
        if (entity == null) {
            return null;
        }
        UserAgentObject object=new UserAgentObject();
        object.setId(entity.getId());
        object.setOs(entity.getOs());
        object.setBrowser(entity.getBrowser());
        object.setApp(entity.getApp());
        object.setNetType(entity.getNetType());
        return object;
    }

}
