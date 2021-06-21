package com.bccoder.mybatis.data.annotation.mappers;

import com.bccoder.mybatis.data.annotation.entity.TUser;
import org.apache.ibatis.annotations.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserAnnoMapper {
    @Select("select id, name,age,address from T_User WHERE id = #{id}")
    TUser findById(@Param("id") Integer id);

    @Select("select id, name,age,address from T_User limit #{currPage},#{pageCount}")
    List<TUser> findAllUserPage(Integer currPage,Integer pageCount);

    @Insert("insert into T_User(name,age,address) value (#{name},#{age},#{address})")
    int insert(TUser user);

    @InsertProvider(type = Provider.class,method="batchInsert")
    int batchInsert(List<TUser> userList);

    @Update("update T_User set name=#{name} where id = #{id}")
    int update(@Param("id") Integer id,@Param("name") String name);

    @Delete("delete from T_User where id =#{id}")
    int delete(@Param("id")Integer id);

    @DeleteProvider(type = Provider.class, method = "batchDelete")
    int batchDelete(List<TUser> students);

    class Provider {
        /* 批量插入 */
        public String batchInsert(Map map) {
            List<TUser> userList = (List<TUser>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO T_User (name,age,address) VALUES ");
            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].name}, #'{'list[{0}].age}, #'{'list[{0}].address})"
            );

            for (int i = 0; i < userList.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                if (i < userList.size() - 1)
                    sb.append(",");
            }
            return sb.toString();
        }

        /* 批量删除 */
        public String batchDelete(Map map) {
            List<TUser> userList = (List<TUser>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM T_User WHERE id IN (");
            for (int i = 0; i < userList.size(); i++) {
                sb.append("'").append(userList.get(i).getId()).append("'");
                if (i < userList.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
