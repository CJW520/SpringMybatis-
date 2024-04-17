package com.cjw.service.impl;

import com.cjw.service.IPubMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* @author MSI
* @description 针对表【pub_menu(操作模块表)】的数据库操作Service实现
* @createDate 2024-04-13 16:15:30
*/
@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class PubMenuService implements IPubMenuService {

}




