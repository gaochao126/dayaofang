package com.jiuyi.yao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.SysCfg;
import com.jiuyi.yao.common.util.URLInvoke;
import com.jiuyi.yao.dto.Page;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @description base action
 * @author zhb
 * @createTime 2015年10月9日
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    /** serialVersionUID. */
    private static final long serialVersionUID = 8725831867311727902L;

    protected final static Logger logger = Logger.getLogger(BaseAction.class);

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    private Map<String, String> params;

    private List<?> dataList;

    private Object dataObj;

    private Page page;

    /**
     * @description 组装数据
     * @param cmd
     * @param clazz
     * @param url
     * @return
     */
	protected List<Object> getPackageDataList(String cmd, Class<?> clazz, String url) {
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("cmd", cmd);
        reqMap.put("deviceType", 3);


        Map<String, Object> params = new HashMap<String, Object>();
        reqMap.put("params", params);
        params.put("page", this.getPage());
        if (this.getParams() != null) {
            params.putAll(this.getParams());
        }

		String result = URLInvoke.post(url, Constants.gson.toJson(reqMap));
        JsonObject json = Constants.jsonParser.parse(result).getAsJsonObject();
        if (!json.has("resultCode") || !"0".equals(json.get("resultCode").getAsString()) || !json.has("detail")) {
            return null;
        }
        if (json.get("detail").getAsJsonObject().has("page")) {
            Page page = Constants.gson.fromJson(json.get("detail").getAsJsonObject().get("page"), Page.class);
            this.setPage(page);
        }
        if (json.get("detail").getAsJsonObject().has("list")) {
            JsonArray ja = json.get("detail").getAsJsonObject().get("list").getAsJsonArray();
            if (!ja.isJsonNull() && ja.size() > 0) {
                List<Object> dataList = new ArrayList<Object>();
                for (int i = 0; i < ja.size(); i++) {
                    dataList.add(Constants.gson.fromJson(ja.get(i), clazz));
                }
                return dataList;
            }
        }
        return null;
    }

    /**
     * @description 组装数据
     * @param reqMap
     */
    protected String packageData(String cmd, Class<?> clazz) {
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("cmd", cmd);
        reqMap.put("deviceType", 3);


        Map<String, Object> params = new HashMap<String, Object>();
        reqMap.put("params", params);
        params.put("page", this.getPage());
        if (this.getParams() != null) {
            params.putAll(this.getParams());
        }

        String result = URLInvoke.post(SysCfg.getString("qujiuyi.patientUrl"), Constants.gson.toJson(reqMap));
        JsonObject json = Constants.jsonParser.parse(result).getAsJsonObject();
        if (!json.has("resultCode") || !"0".equals(json.get("resultCode").getAsString()) || !json.has("detail")) {
            return result;
        }
        if (json.get("detail").getAsJsonObject().has("page")) {
            Page page = Constants.gson.fromJson(json.get("detail").getAsJsonObject().get("page"), Page.class);
            this.setPage(page);
        }
        if (json.get("detail").getAsJsonObject().has("list")) {
            JsonArray ja = json.get("detail").getAsJsonObject().get("list").getAsJsonArray();
            if (!ja.isJsonNull() && ja.size() > 0) {
                List<Object> dataList = new ArrayList<Object>();
                for (int i = 0; i < ja.size(); i++) {
                    dataList.add(Constants.gson.fromJson(ja.get(i), clazz));
                }
                this.setDataList(dataList);
            }
        }
        this.setDataObj(Constants.gson.fromJson(json.get("detail"), clazz));
        return result;
    }

    /**
     * @description 向前端响应数据
     * @param reqMap
     */
	protected String printData(String cmd, Class<?> clazz) {
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("cmd", cmd);
        reqMap.put("deviceType", 3);

        Map<String, Object> params = new HashMap<String, Object>();
        reqMap.put("params", params);
        params.put("page", this.getPage());
        if (this.getParams() != null) {
            params.putAll(this.getParams());
        }

		String result = URLInvoke.post(SysCfg.getString("qujiuyi.patientUrl"), Constants.gson.toJson(reqMap));
        print(result);

        JsonObject json = Constants.jsonParser.parse(result).getAsJsonObject();
        if (!json.has("resultCode") || !"0".equals(json.get("resultCode").getAsString()) || !json.has("detail")) {
            return result;
        }
        if (json.get("detail").getAsJsonObject().has("page")) {
            Page page = Constants.gson.fromJson(json.get("detail").getAsJsonObject().get("page"), Page.class);
            this.setPage(page);
        }
        if (json.get("detail").getAsJsonObject().has("list")) {
            JsonArray ja = json.get("detail").getAsJsonObject().get("list").getAsJsonArray();
            if (!ja.isJsonNull() && ja.size() > 0) {
                List<Object> dataList = new ArrayList<Object>();
                for (int i = 0; i < ja.size(); i++) {
                    dataList.add(Constants.gson.fromJson(ja.get(i), clazz));
                }
                this.setDataList(dataList);
            }
        }
        this.setDataObj(Constants.gson.fromJson(json.get("detail"), clazz));

        return result;
    }

    /**
     * @description 获取请求结果
     * @param cmd
     * @param clazz
     * @return
     */
	public String getReqResult(String cmd, Class<?> clazz, String reqUrl) {
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("cmd", cmd);
        reqMap.put("deviceType", 3);

        Map<String, Object> params = new HashMap<String, Object>();
        reqMap.put("params", params);
        params.put("page", this.getPage());
        if (this.getParams() != null) {
            params.putAll(this.getParams());
        }

		String result = URLInvoke.post(reqUrl, Constants.gson.toJson(reqMap));

        JsonObject json = Constants.jsonParser.parse(result).getAsJsonObject();
        if (!json.has("resultCode") || !"0".equals(json.get("resultCode").getAsString()) || !json.has("detail")) {
            return result;
        }
        if (json.get("detail").getAsJsonObject().has("page")) {
            Page page = Constants.gson.fromJson(json.get("detail").getAsJsonObject().get("page"), Page.class);
            this.setPage(page);
        }
        if (json.get("detail").getAsJsonObject().has("list")) {
            JsonArray ja = json.get("detail").getAsJsonObject().get("list").getAsJsonArray();
            if (!ja.isJsonNull() && ja.size() > 0) {
                List<Object> dataList = new ArrayList<Object>();
                for (int i = 0; i < ja.size(); i++) {
                    dataList.add(Constants.gson.fromJson(ja.get(i), clazz));
                }
                this.setDataList(dataList);
            }
        }
        this.setDataObj(Constants.gson.fromJson(json.get("detail"), clazz));

        return result;
    }

    /**
     * @description 向前端响应数据
     * @param reqMap
     */
    protected String printData(String cmd) {
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("cmd", cmd);
        reqMap.put("deviceType", 3);


        Map<String, Object> params = new HashMap<String, Object>();
        reqMap.put("params", params);
        params.put("page", this.getPage());
        if (this.getParams() != null) {
            params.putAll(this.getParams());
        }

        String result = URLInvoke.post(SysCfg.getString("qujiuyi.patientUrl"), Constants.gson.toJson(reqMap));
        print(result);
        return result;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * @description 获取writer
     * @return
     * @throws IOException
     */
    protected PrintWriter getWriter() throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("pragma", "no-cache");
        response.setHeader("expires", "0");
        return response.getWriter();
    }

    /**
     * @description <描述>
     * @param oject
     */
    protected void print(Object oject) {
        PrintWriter out = null;
        try {
            out = getWriter();
            out.print(oject);
        } catch (IOException e) {
            logger.error("响应异常", e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * @description 从参数中
     * @param clazz
     * @return
     */
    protected <T> T getDtoFromParams(Class<T> clazz) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", this.getPage());
        if (this.getParams() != null) {
            map.putAll(this.getParams());
        }
        return Constants.gson.fromJson(Constants.gson.toJson(map), clazz);
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public Object getDataObj() {
        return dataObj;
    }

    public void setDataObj(Object dataObj) {
        this.dataObj = dataObj;
    }
}