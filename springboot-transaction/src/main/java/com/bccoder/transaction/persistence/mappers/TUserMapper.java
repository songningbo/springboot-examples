package com.bccoder.transaction.persistence.mappers;

import com.bccoder.transaction.persistence.entity.TUser;
import com.bccoder.transaction.persistence.entity.TUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface TUserMapper {

    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}