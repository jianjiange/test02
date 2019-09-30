package com.atguigu.gmalltest.demo.service.Impl;

import com.atguigu.gmalltest.demo.bean.UserInfo;
import com.atguigu.gmalltest.demo.mapper.UserInfoMapper;
import com.atguigu.gmalltest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {


        @Autowired
        private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {



        //return userInfoMapper.selectByExample();

        return  userInfoMapper.select(userInfo);
    }

    @Override
    public List<UserInfo> findByLoginName(String loginName) {

        //构造查询条件
        Example example = new Example(UserInfo.class);
        //构建查询器
        example.createCriteria().andLike("loginName","%"+loginName+"%");
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updUser(UserInfo userInfo) {


      //  userInfoMapper.updateByPrimaryKeySelective(userInfo);

        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void delUser(UserInfo userInfo) {
        userInfoMapper.deleteByPrimaryKey(userInfo);

        //根据id的范围删除 delete from userInfo where id in ?
        //        Example example = new Example(UserInfo.class);
        //        example.createCriteria().andIn("id",);
        //        userInfoMapper.deleteByExample(example);
    }
}
