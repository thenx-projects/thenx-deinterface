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

package org.thenx.dao;

import org.apache.ibatis.annotations.Param;
import org.thenx.entity.UnifiedRetrieveEntity;
import org.thenx.utility.PageView;

import java.util.List;
import java.util.Map;

public interface UnifiedRetrieveMapper {

    /**
     * 查询所有公司信息
     *
     * @return null
     */
    List<UnifiedRetrieveEntity> queryAll(@Param("pageView") PageView pageView);

    /**
     * 删除操作
     *
     * @param dsCode
     * @return null
     */
    Integer deleteByExample(@Param("dsCode") String dsCode);

    /**
     * 插入
     *
     * @param record
     * @return null
     */
    Integer insert(UnifiedRetrieveEntity record);

    /**
     * 根据DS_CODE查询
     *
     * @param dsCode
     * @return null
     */
    UnifiedRetrieveEntity selectByDsCode(@Param("dsCode") String dsCode);

    /**
     * 更新操作
     *
     * @param record
     * @return null
     */
    Integer update(@Param("record") UnifiedRetrieveEntity record);

    /**
     * 动态执行SQL
     *
     * @return
     */
    List<Map<String, String>> executionSql(@Param("map") Map<String, String> map);

    /**
     * 动态执行SQL 修改语句
     *
     * @return
     */
    Integer executionSqlforUpdate(@Param("map") Map<String, String> map);

    /**
     * 动态执行SQL 插入语句
     *
     * @param map
     * @return
     */
    Integer executionSqlforInsert(@Param("map") Map<String, String> map);

    /**
     * 分页执行SQL
     *
     * @param pageView
     * @return
     */
    List<Map<String, String>> querySqlAndPageView(@Param("pageView") PageView pageView);
}
