package hello.service;

import hello.object.UserAgentObject;

import java.util.List;

/**
 * Created by yunsu on 2016/5/20.
 */
public interface UserAgentService {
    UserAgentObject getUserAgentByString(String string);
}