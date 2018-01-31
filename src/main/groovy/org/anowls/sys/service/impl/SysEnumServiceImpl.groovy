package org.anowls.sys.service.impl

import org.anowls.sys.common.PageQuery
import org.anowls.sys.common.SimplePage
import org.anowls.sys.common.message.SimpleMessage
import org.anowls.sys.domain.SysEnum
import org.anowls.sys.domain.SysEnumItem
import org.anowls.sys.domain.view.SysEnumVO
import org.anowls.sys.mapper.SysEnumMapper
import org.anowls.sys.service.SysEnumService

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>Title: sys-platform</p>
 * <p>Description: 这里填写描述信息</p>
 * <p>Copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved</p>
 * <p>Company: http://www.hanboard.com</p>
 *
 * @author haopeisong
 * @date 2018/1/26 0026
 */
@Service
class SysEnumServiceImpl implements SysEnumService {

    @Autowired
    private SysEnumMapper sysEnumMapper

    @Override
    List<SysEnumVO> queryByCodes(String codes) {
        return null
    }

    @Override
    SimplePage<SysEnum> query(PageQuery pagerQuery) {
        PageHelper.startPage(pagerQuery.getPage(), pagerQuery.getSize())
        List<SysEnum> sysEnums = sysEnumMapper.selectAll()
        PageInfo<SysEnum> pageInfo = new PageInfo<SysEnum>(sysEnums)
        new SimplePage<SysEnum>().convert(pageInfo)
    }

    @Override
    SimpleMessage getById(String id) {
        SimpleMessage.info(sysEnumMapper.selectByPrimaryKey(id))
    }

    @Override
    SimpleMessage insert(SysEnum sysEnum) {
        return null
    }

    @Override
    SimpleMessage update(SysEnum sysEnum) {
        return null
    }

    @Override
    SimpleMessage delete(String id) {
        return null
    }

    @Override
    SimpleMessage enable(String id) {
        return null
    }

    @Override
    SimpleMessage disable(String id) {
        return null
    }

    @Override
    SimpleMessage getItemById(String id) {
        return null
    }

    @Override
    SimplePage<SysEnumItem> queryItem(PageQuery pageQuery) {
        return null
    }

    @Override
    SimpleMessage insertItem(SysEnumItem enumItem) {
        return null
    }

    @Override
    SimpleMessage updateItem(SysEnumItem enumItem) {
        return null
    }

    @Override
    SimpleMessage deleteItem(List<String> ids) {
        return null
    }

    @Override
    SimpleMessage enableItem(String id) {
        return null
    }

    @Override
    SimpleMessage disableItem(String id) {
        return null
    }
}
