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

package org.thenx.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thenx.Result;
import org.thenx.entity.UnifiedRetrieveEntity;
import org.thenx.service.UnifiedRetrieveService;
import org.thenx.utility.PageView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/datasources")
public class UnifiedRetrieveController {


    @Resource
    private UnifiedRetrieveService datasourceService;

    /**
     * 查询所有的配置表信息
     */
    @PostMapping("/queryAll")
    public PageView queryAll(@RequestParam(value = "dsCode", required = false) String dsCode,
                             @RequestParam(value = "tblName", required = false) String tblName,
                             @RequestParam(value = "dsDesc", required = false) String dsDesc,
                             @RequestParam(value = "orderClause", required = false) String orderClause,
                             @RequestParam("pageNo") Integer pageNo) {
        PageView pageView = new PageView();
        Map<String, String> map = new HashMap<>();
        map.put("dsCode", dsCode);
        map.put("tblName", tblName);
        map.put("dsDesc", dsDesc);
        map.put("orderClause", orderClause);
        pageView.setPageNow(pageNo);
        pageView.setQueryMap(map);
        try {
            pageView = datasourceService.queryAll(pageView);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return pageView;
    }

    /**
     * 查询单条配置表信息
     *
     * @param dsCode
     * @return null
     */
    @PostMapping(value = "/findByDsCode")
    public Result findByDsCode(@RequestParam("dsCode") String dsCode) {
        Result result = new Result();
        UnifiedRetrieveEntity byDsCode = new UnifiedRetrieveEntity();
        try {
            byDsCode = datasourceService.findByDsCode(dsCode);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setSuccess(false);
        }
        result.setData(byDsCode);
        return result;
    }

    /**
     * 插入/更新配置表信息
     *
     * @param datasourceEntity
     * @return null
     */
    @PostMapping(value = "/changeDatasource")
    public Result changeDatasource(@RequestBody UnifiedRetrieveEntity datasourceEntity) {
        Result result = new Result();
        Integer status = 1;
        try {
            status = datasourceService.changeSmDatasource(datasourceEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (status == 1) {
            result.setData(true);
        } else if (status == -1) {
            result.setMsg("ExceptionExplain.ERROR_BY_INSERT.getExplain()");
            result.setSuccess(false);
        } else if (status == -2) {
            result.setMsg("ExceptionExplain.ERROR_BY_UPDATE.getExplain()");
            result.setSuccess(false);
        } else {
            result.setMsg("ExceptionExplain.ERROR_BY_INFOS.getExplain()");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 删除配置表信息
     *
     * @param dsCode
     * @return null
     */
    @DeleteMapping(value = "/delDatasource")
    public Result delDatasource(@RequestParam("dsCode") String dsCode) {
        Result result = new Result();
        Integer status = 1;
        try {
            status = datasourceService.delSmDatasource(dsCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (status == 1) {
            result.setData(true);
        } else {
            result.setMsg("ExceptionExplain.ERROR_BY_DELETE.getExplain()");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 动态执行 SQL
     *
     * @param params
     * @return null
     */
    @CrossOrigin
    @PostMapping(value = "/executionSql")
    public Result executinoSql(@RequestParam Map<String, String> params) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Result result = new Result();
        UnifiedRetrieveEntity byDsCode = datasourceService.findByDsCode(params.get("dsCode"));
        if (null == byDsCode) {
            result.setMsg("ExceptionExplain.EMPTY_BY_DATA.getExplain()");
            result.setSuccess(false);
            return result;
        }
        params.put("sql", byDsCode.getSelectClause());
        params.put("pms", request.getHeader("pms"));
        List<Map<String, String>> maps = datasourceService.executionSql(params);
        result.setData(maps);
        return result;
    }

    /**
     * 动态执行 SQL 并分页
     *
     * @param params
     * @return null
     */
    @PostMapping(value = "/executinoSqlWithPage")
    public PageView executinoSqlWithPage(@RequestParam Map<String, String> params) {
        PageView pageView = new PageView();
        int pageNow = Integer.parseInt(params.get("pageNow"));
        int pageSize = Integer.parseInt(params.get("pageSize"));
        String dsCode = params.get("dsCode");
        params.remove("pageNow");
        params.remove("pageSize");
        params.remove("dsCode");
        UnifiedRetrieveEntity byDsCode = datasourceService.findByDsCode(dsCode);
        params.put("sql", byDsCode.getSelectClause());
        pageView.setQueryMap(params);
        pageView.setPageNow(pageNow);
        pageView.setPageSize(pageSize);
        try {
            pageView = datasourceService.executionSqlPageView(pageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageView;
    }


    /**
     * 动态执行 SQL 并分页
     *
     * @param params
     * @return null
     */
    @PostMapping(value = "/executinoSqlWithPageTgp")
    public PageView executinoSqlWithPageTgp(@RequestParam Map<String, String> params) {
        PageView pageView = new PageView();
        Integer pageNow = Integer.parseInt(params.get("pageNow"));
        Integer pageSize = Integer.parseInt(params.get("pageSize"));
        String dsCode = params.get("dsCode");
        String pms = params.get("PMS");
        params.remove("pageNow");
        params.remove("pageSize");
        params.remove("dsCode");
        UnifiedRetrieveEntity byDsCode = datasourceService.findByDsCode(dsCode);
        params.put("sql", byDsCode.getSelectClause());
        pageView.setQueryMap(params);
        pageView.setPageNow(pageNow);
        pageView.setPageSize(pageSize);
        try {
            pageView = datasourceService.executinoSqlWithPageTgp(pageView, pms);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageView;
    }
}
