package hello.service.impl;

import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Utils;
import hello.object.UserAgentObject;
import hello.service.UserAgentService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yunsu on 2016/5/20.
 */
@Service("userAgentService")
public class UserAgentServiceImpl implements UserAgentService {
    @Override
    public UserAgentObject getUserAgentByString(String string) {
        UserAgentObject object=new UserAgentObject();
        UserAgent userAgent=UserAgent.parseUserAgentString(string);
        object.setOs(userAgent.getOperatingSystem().toString());
        object.setBrowser(userAgent.getBrowser().toString());
        object.setApp("UC");
        object.setNetType("WIFI");
        return object;
    }
}
