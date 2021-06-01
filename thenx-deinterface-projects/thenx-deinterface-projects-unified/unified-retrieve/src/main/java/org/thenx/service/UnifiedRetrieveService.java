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

package org.thenx.service;

import org.thenx.entity.UnifiedRetrieveEntity;
import org.thenx.utility.PageView;

import java.util.List;
import java.util.Map;

public interface UnifiedRetrieveService {

    /**
     * 查数据源相关信息
     *
     * @return null
     */
    PageView queryAll(PageView pageView);

    /**
     * 查询单条配置表
     *
     * @param dsCode
     * @return null
     */
    UnifiedRetrieveEntity findByDsCode(String dsCode);

    /**
     * 增加/修改查询语句配置表
     *
     * @param datasourceEntity
     * @return null
     */
    Integer changeSmDatasource(UnifiedRetrieveEntity datasourceEntity);

    /**
     * 删除配置表
     *
     * @param dsCode
     * @return null
     */
    Integer delSmDatasource(String dsCode);

    /**
     * 动态SQL执行
     *
     * @return
     */
    List<Map<String, String>> executionSql(Map<String, String> map);

    /**
     * 动态SQL执行更新
     *
     * @return
     */
    Integer executionSqlforUpdate(Map<String, String> map);

    /**
     * 动态SQL执行插入
     *
     * @return
     */
    Integer executionSqlforInsert(Map<String, String> map);

    /**
     * 动态SQL执行并分页
     *
     * @param pageView
     * @return
     */
    PageView executionSqlPageView(PageView pageView);

    /**
     * 动态SQL TGP执行并分页
     *
     * @param pageView
     * @param PMS
     * @return
     */
    PageView executinoSqlWithPageTgp(PageView pageView, String PMS);
}
