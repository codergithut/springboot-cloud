package com.config;

public class ConstantParam {

    /**
     * 与elasticsearch交换数据的方式
     */
    public static final String ELASTICSEARCH_SCHEME="http";

    /**
     * 通过HTTP方式使用跟新插件
     */
    public static final String UPDATE_PLUGIN = "/_update_by_query";

    /**
     * 通关HTTP方式时候用删除插件
     */
    public static final String DELETE_PLUGIN = "/_delete_by_query";

    /**
     * 跟新数据的脚本
     */
    public static final String UPDATE_SEARCH = "{\"script\": {\n" +
            "    \"source\": \"ctx._source['$param'] = $value \"\n" +
            "  },\n" +
            "  \"query\": { \n" +
            "    \"match\": {\n" +
            "      \"$searchParam\": \"$searchValue\"\n" +
            "    }\n" +
            "  } }";

    /**
     * 删除数据的脚本
     */
    public static final String DELETE_SEARCH = "{\"query\": { \n" +
            "    \"match\": {\n" +
            "      \"$searchParam\": \"$searchValue\"\n" +
            "    }\n" +
            "  }}";
}
