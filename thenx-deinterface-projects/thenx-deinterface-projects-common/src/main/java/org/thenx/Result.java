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

package org.thenx;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wales
 * <p>
 * 自定义返回值
 * </p>
 *
 * <ul>
 *     <li> 1. serialVersionUID</li>
 *     <li> 2. success: 操作状态</li>
 *     <li> 3. id: 用于写入操作后的主键返回</li>
 *     <li> 4. msg: 返回消息</li>
 *     <li> 5. data: 返回数据</li>
 * </ul>
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -7319737625485900657L;

    private boolean success = true;

    private String id;

    private String msg = "操作成功";

    private Object data;
}

