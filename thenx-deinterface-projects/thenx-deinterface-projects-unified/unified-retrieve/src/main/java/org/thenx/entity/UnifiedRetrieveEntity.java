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

package org.thenx.entity;

import lombok.Data;

/**
 * @author wales
 * <p>
 * 数据源基本数据模型
 */
@Data
public class UnifiedRetrieveEntity {

    /**
     * 配置表编码
     */
    private String dsCode;

    /**
     * 表名
     */
    private String tblName;

    /**
     * 描述
     */
    private String dsDesc;

    /**
     * 查看数据源
     */
    private String dsCat;

    /**
     * 类型
     */
    private String dsType;

    /**
     * 具体SQL语句
     */
    private String selectClause;

    /**
     * 条件
     */
    private String orderClause;
}
