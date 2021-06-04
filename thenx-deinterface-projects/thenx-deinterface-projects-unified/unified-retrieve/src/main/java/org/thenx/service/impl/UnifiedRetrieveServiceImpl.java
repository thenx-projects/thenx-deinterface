/*
 * Copyright [2021-2021] [Thenx Projects]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.thenx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thenx.dao.UnifiedRetrieveMapper;
import org.thenx.entity.UnifiedRetrieveEntity;
import org.thenx.service.UnifiedRetrieveService;
import org.thenx.utility.Common;
import org.thenx.utility.PageView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class UnifiedRetrieveServiceImpl implements UnifiedRetrieveService {

    @Resource
    private UnifiedRetrieveMapper datasourceMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询所有公司相关数据源
     *
     * @return null
     */
    @Override
    public PageView queryAll(PageView pageView) {
        List<UnifiedRetrieveEntity> dataSources = new ArrayList<>();
        try {
            dataSources = datasourceMapper.queryAll(pageView);
            pageView.setRecords(dataSources);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageView;
    }

    /**
     * 查询单条配置表
     *
     * @param dsCode
     * @return null
     */
    @Override
    public UnifiedRetrieveEntity findByDsCode(String dsCode) {
        return datasourceMapper.selectByDsCode(dsCode);
    }

    /**
     * 增加或者修改配置表
     *
     * @param datasourceEntity
     * @return null
     */
    @Override
    public Integer changeSmDatasource(UnifiedRetrieveEntity datasourceEntity) {
        Integer status = 1;
        UnifiedRetrieveEntity byDsCode = datasourceMapper.selectByDsCode(datasourceEntity.getDsCode());
        if (null == byDsCode) {
            try {
                status = datasourceMapper.insert(datasourceEntity);
            } catch (Exception e) {
                status = -1;
                e.printStackTrace();
            }

        } else {
            try {
                status = datasourceMapper.update(datasourceEntity);
            } catch (Exception e) {
                status = -2;
                e.printStackTrace();
            }
        }
        return status;
    }

    /**
     * 删除操作没得说
     *
     * @param dsCode
     * @return null
     */
    @Override
    public Integer delSmDatasource(String dsCode) {
        Integer status = 1;
        UnifiedRetrieveEntity byDsCode = datasourceMapper.selectByDsCode(dsCode);
        if (byDsCode.getDsCode() == null || byDsCode.getDsCode().isEmpty()) {
            status = -1;
        } else {
            try {
                status = datasourceMapper.deleteByExample(dsCode);
            } catch (Exception e) {
                status = -2;
                e.printStackTrace();
            }
        }
        return status;
    }

    /**
     * 动态执行 SQL
     *
     * @param map
     * @return
     */
    @Override
    public List<Map<String, String>> executionSql(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        Map<String, String> fixSql = Common.fixSql(map);
        List<Map<String, String>> maps = new ArrayList<>();
        try {
            maps = datasourceMapper.executionSql(fixSql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maps;
    }

    @Override
    public PageView executionSqlPageView(PageView pageView) {
        Map map = Common.fixSql(pageView.getQueryMap());
        pageView.setQueryMap(map);
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            mapList = datasourceMapper.querySqlAndPageView(pageView);
            pageView.setRecords(mapList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageView;
    }

    /**
     * 动态SQL TGP执行并分页
     *
     * @param pageView
     * @param PMS
     * @return
     */
    @Override
    public PageView executinoSqlWithPageTgp(PageView pageView, String PMS) {
        return null;
    }

    @Override
    public Integer executionSqlforUpdate(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        Map<String, String> fixSql = Common.fixSql(map);
        Integer i = -1;
        try {
            i = datasourceMapper.executionSqlforUpdate(fixSql);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
        return i;
    }

    @Override
    public Integer executionSqlforInsert(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        Map<String, String> fixSql = Common.fixSql(map);
        Integer i = -1;
        try {
            i = datasourceMapper.executionSqlforInsert(fixSql);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
        return i;
    }
}
