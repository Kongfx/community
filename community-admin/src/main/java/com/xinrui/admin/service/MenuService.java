package com.xinrui.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.xinrui.admin.entity.Menu;

/**
 * <p>
 * MENU 服务类
 * </p>
 *
 * @author kongfx
 * @since 2019-04-28
 */
public interface MenuService extends IService<Menu> {

	default void forEach() {
		System.out.println();
	}
}

