package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.entity.TypeExample;
import com.kgc.mapper.TypeMapper;
import com.kgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = typeMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override//删除多条
    public int deleteMore(Integer[]ids) {
        int i = typeMapper.deleteMore(ids);

        return i;
    }

    @Override//添加
    public int insert(Type type) {
        int insert = typeMapper.insert(type);
        return insert;
    }

    @Override
    public int insertSelective(Type type) {
        return 0;
    }

    @Override//不分页查询所有
    public List<Type> selectByExample() {
        TypeExample typeExample = new TypeExample();
        List<Type> types = typeMapper.selectByExample(typeExample);
        return types;
    }

    @Override//查询所有
    public PageInfo<Type> selectAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Type> types = typeMapper.selectAll();
        PageInfo<Type> PageInfo = new PageInfo<>(types);
        return PageInfo;
    }

    @Override
    public List<Type> selectAllType() {
        List<Type> types = typeMapper.selectAll();
        return types;
    }

    @Override//根据主键查找
    public Type selectByPrimaryKey(Integer id) {
        Type type = typeMapper.selectByPrimaryKey(id);
        return null;
    }

    @Override//选择修改
    public int updateByPrimaryKeySelective(Type type) {
        int i = typeMapper.updateByPrimaryKeySelective(type);
        return i;
    }

    @Override
    public int updateByPrimaryKey(Type type) {
        return 0;
    }
}
