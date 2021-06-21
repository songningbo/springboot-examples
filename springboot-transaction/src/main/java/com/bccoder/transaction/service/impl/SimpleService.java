package com.bccoder.transaction.service.impl;

import com.bccoder.transaction.persistence.entity.TUser;
import com.bccoder.transaction.persistence.mappers.TUserMapper;
import com.bccoder.transaction.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.sql.SQLException;

@Slf4j
@Service
public class SimpleService implements IService {

    @Resource
    private TUserMapper tUserMapper;

    @Autowired
    PlatformTransactionManager txManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

//    private final TransactionTemplate transactionTemplate;
//    public SimpleService(PlatformTransactionManager platformTransactionManager) {
//        transactionTemplate = new TransactionTemplate(platformTransactionManager);
//        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
//        transactionTemplate.setTimeout(30);//事务超时时间 30seconds
//    }
//
//    /**
//     * 演示1. TransactionTemplate手动操作提交和回滚
//     * @param id
//     */
//    @Override
//    public void deleteUser(Integer id) {
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                try {
//                    log.info("transactionTemplate start");
//                    tUserMapper.deleteByPrimaryKey(id);
//                    if (id == 1) {
//                        throw new SQLException("Database transaction error!!");
//                    }
//                    log.info("transactionTemplate end");
//                } catch (SQLException e) {
//                    log.info("transactionTemplate rollback");
//                    transactionStatus.setRollbackOnly(); // rollback
//                }
//            }
//        });
//    }

    /**
     * 演示2. PlatformTransactionManager手动操作提交和回滚
     */
//    @Override
//    public void updateUser(){
//        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
//        definition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
//        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        TransactionStatus status = txManager.getTransaction(definition);
//        try {
//            log.info("PlatformTransactionManager start");
//            jdbcTemplate.update("update T_User set name='Tom' where id=1");
//            if(true){
//                throw new SQLException();
//            }
//            txManager.commit(status);
//            log.info("PlatformTransactionManager end");
//        } catch (SQLException e) {
//            log.info("PlatformTransactionManager rollback");
//            txManager.rollback(status);
//        }
//    }

    /**
     * 演示3. Transactional 自动提交与回滚
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateUser(Integer id) {
        log.info("transactional start");
        jdbcTemplate.update("update T_User set name='Tom' where id=1");
        log.info("transactional end");
    }

    /**
     * 演示4. TX和AOP的xml配置方式
     */
//    @Override
//    public void updateUser(){
//        log.info("PlatformTransactionManager start");
//        TUser tUser = new TUser();
//        tUser.setId(1);
//        tUser.setName("tom");
//        tUserMapper.updateByPrimaryKey(tUser);
//        int i=1/0;
//    }
}
