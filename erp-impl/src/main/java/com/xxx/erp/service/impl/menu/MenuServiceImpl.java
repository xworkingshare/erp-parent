package com.xxx.erp.service.impl.menu;

import com.xxx.erp.bean.menu.Menu;
import com.xxx.erp.dao.menu.MenuDao;
import com.xxx.erp.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: MenuServiceImpl
 * @Description: 菜单 Menu Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/7  0:49
 * @Version: 1.0
 **/
@Service
@Transactional
public class MenuServiceImpl implements IMenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public Menu getSelfWithChildrenByMenuid(String menuid) {

        Menu menu = menuDao.selectSelfWithChildrenByMenuid(menuid);

        return menu;
    }

    @Override
    public List<Menu> getMenusByEmpUUid(String empuuid) {

        List<Menu> menuList = menuDao.selectMenusByEmpUuid(empuuid);

        return menuList;
    }
}
