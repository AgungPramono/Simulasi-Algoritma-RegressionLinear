/*
 * Copyright (C) 2016 Agung Pramono.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 *  SqlHelper.java
 */
package com.agung.regresi.dao;

/**
 *
 * @Created by : agung
 * @Date : 11/Aug/2016
 *
 */
public interface SqlHelper {

    /**
     * Query untuk hasil uji
     */
    String INSERT_QUERY_RESULT
            = "insert into nilai (uas,un) values(?,?)";

    String GET_ALL_QUERY_RESULT
            = "select * from nilai order by id asc";
    
    String UPDATE_QUERY
            = "update nilai set uas=?,un=? where id=?";

    String DELETE_QUERY
            = "delete from nilai where id=?";
     String DELETE_ALL_QUERY
            = "delete from nilai";
     
     String INSERT_QUERY_TESTING
            = "insert into testing (uas) values(?)";

    String GET_ALL_QUERY_TESTING
            = "select * from testing order by id asc";
    
    String UPDATE_QUERY_TESTING
            = "update testing set uas=? where id=?";

    String DELETE_QUERY_TESTING
            = "delete from testing where id=?";
     String DELETE_ALL_QUERY_TESTING
            = "delete from testing";

}
