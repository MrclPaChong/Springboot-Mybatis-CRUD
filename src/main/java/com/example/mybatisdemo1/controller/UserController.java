package com.example.mybatisdemo1.controller;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:28
 * description： 小程序端测试接口
 */

import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.enums.UserSexEnum;
import com.example.mybatisdemo1.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {

    //@Autowired
    @Resource
    UserService userService;

    /**
     *  分页查询
     */
    @PostMapping(value = "/getAllUser")
    public Object getAllUser(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "10")int size){
        return userService.getAllUser1(page, size);
    }

    /**
     *  添加
     */
    @PostMapping(value = "/insert")
    public int insert(@Param("userInfoId") Long userInfoId,
                       @Param("username") String userName,
                       @Param("age") Integer age,
                       @Param("sex") String sex){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserInfoId(userInfoId);
        userInfo.setUserName(userName);
        userInfo.setAge(age);
        userInfo.setSex(UserSexEnum.MAN.toString());
        return userService.insert(userInfo);

    }

    /**
     *  根据ID删除
     */
    @PostMapping(value = "/delete")
    public int delete(Long userInfoId){
        return userService.delete(userInfoId);
    }

    /**
     *  更新
     * @param userInfo
     * @return
     */
    @PostMapping(value = "/update")
    public int update(UserInfo userInfo){
        return userService.update(userInfo);
    }

    /**
     *  根据ID更新字段
     */
    @PostMapping(value = "/updateById")
    public int updateById(Long userInfoId, String userName,Integer age,String sex){
        return userService.updateById(userInfoId,userName,age, sex);
    }


    //    @PostMapping(value = "/updateById")
    //    public int updateById(@Param("userInfoId") Long userInfoId, @Param("userName") String userName, @Param("age") String age, @Param("sex") String sex){
    //        return userService.updateById(userInfoId, userName, age, sex);
    //    }

}
