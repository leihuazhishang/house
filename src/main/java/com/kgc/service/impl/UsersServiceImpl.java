package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.UserCondition;
import com.kgc.entity.Users;
import com.kgc.entity.UsersExample;
import com.kgc.mapper.UsersMapper;
import com.kgc.service.UsersService;
import com.kgc.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = usersMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int deleteUsers(Integer districtId) {
        return 0;
    }

    @Override
    public int deleteMore(Integer[] ids) {
        int i = usersMapper.deleteMore(ids);
        return i;
    }

    @Override
    public int insert(Users user) {
        int i = usersMapper.insert(user);
        return i;
    }

    @Override//前台用户注册
    public int frontInsert(Users user) {
       user.setIsadmin(0);
       user.setPassword(MD5Utils.md5Encrypt(user.getPassword()));
        int i = usersMapper.insert(user);
        return i;
    }

    @Override
    public int selectByExample1(String name) {
        int i;
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Users> users = usersMapper.selectByExample(usersExample);
           i=users.size()==0?0:1;
        return i;
    }

    @Override
    public int insertSelective(Users users) {
        return 0;
    }

    @Override
    public PageInfo<Users> selectByExample(UserCondition userCondition) {
        //开启分页
        PageHelper.startPage(userCondition.getPage(),userCondition.getRows());
               //创建userExample对象
       UsersExample usersExample = new UsersExample();
       //添加查询条件
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(new Integer(1));
        if(userCondition.getTelephone()!=null){
            criteria.andTelephoneLike("%"+userCondition.getTelephone()+"%");
        }
        if(userCondition.getStartAge()!=null){
            criteria.andAgeGreaterThan(userCondition.getStartAge());
        }
        if(userCondition.getEndAge()!=null){
            criteria.andAgeLessThan(userCondition.getEndAge());
        }
        //调用userMapper的方法执行查询得到查询结果
        List<Users> users = usersMapper.selectByExample(usersExample);
        PageInfo<Users>pageInfo=new PageInfo<>(users);

        return pageInfo;
    }

    @Override
    public Users selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Users user) {
        int i = usersMapper.updateByPrimaryKeySelective(user);
        return i;
    }

    @Override
    public int updateByPrimaryKey(Users users) {
        return 0;
    }

    @Override//前台用户登录
    public Users selectByExample2(String userName, String password) {

        password=MD5Utils.md5Encrypt(password);
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(0);
        criteria.andNameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        List<Users> users = usersMapper.selectByExample(usersExample);
        Users user=users.get(0);

        return user;
    }
}
