package com.whalex.usercentre.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whalex.userCentre.api.entity.SysRole;
import com.whalex.userCentre.api.vo.SysRoleVO;

import java.util.List;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/2 21:57
 */
public interface ISysRoleService extends IService<SysRole> {
    List<SysRoleVO> getCustomerRoleById(Long customerId);
    List<SysRole> getRolesBytenantCode();
    Boolean saveOrUpdateSysRole(SysRole sysRole);
    Boolean deleteSysRole(Long id);
    IPage<SysRoleVO> getRolesPage(SysRoleVO sysRoleVO);
}
