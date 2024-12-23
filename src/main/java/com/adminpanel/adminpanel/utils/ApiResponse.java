package com.adminpanel.adminpanel.utils;

import java.util.HashMap;

public class ApiResponse {
    public HashMap<String,Boolean> addKeyValue(Boolean value){
        HashMap<String,Boolean> map = new HashMap<>();
        map.put("success",value);
        return map;
    }
}
