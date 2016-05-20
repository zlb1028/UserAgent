package hello.repository;

import hello.entity.UserAgentEntity;
import hello.repository.basic.FindOneAndSaveRepository;

/**
 * Created by yunsu on 2016/5/20.
 */
public interface UserAgentRepository extends FindOneAndSaveRepository<UserAgentEntity, String> {


}
