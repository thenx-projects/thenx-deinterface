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

create table sm_datasource
(
    id           varchar(50)   not null
        primary key,
    ds_code       varchar(200)  not null,
    table_name      varchar(200)  not null,
    ds_desc       varchar(200)  not null,
    ds_cat        varchar(200)  not null,
    ds_type       varchar(200)  not null,
    select_clause varchar(2000) not null,
    order_clause  varchar(200)  null

)
    comment '数据源测试表';
