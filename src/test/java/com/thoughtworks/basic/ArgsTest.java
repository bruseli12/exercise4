package com.thoughtworks.basic;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ArgsTest {
   /* @Test
    public void should_return_boolean_when_get_type_given_l() {
        //given
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        FlagSchema flagSchema_l = new FlagSchema("l", Boolean.TYPE);
        flagSchemaSet.add(flagSchema_l);
        Schema schema = new Schema(flagSchemaSet);
        //when
        Object type = schema.getTypeofFlag("l");
        //then
        assertEquals(type, Boolean.TYPE);
    }

    @Test
    public void should_return_String_when_get_type_given_d() {
        //given
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        FlagSchema flagSchema_d = new FlagSchema("d", String.class);
        flagSchemaSet.add(flagSchema_d);
        Schema schema = new Schema(flagSchemaSet);
        //when
        Object type = schema.getTypeofFlag("p");
        //then
        assertEquals(type, String.class);
    }
   @Test
    public void should_return_string_list_when_scan_given_string() {
        //given
        String argsText="-l true -p 8080 -d /usr/logs";
        Args args=new Args(argsText);
        //when
        List<KeyValuePair> keyValuePairs =args.scan();
        //then
        assertEquals(3,keyValuePairs.size());
        assertTrue(keyValuePairs.contains(new KeyValuePair("l", "true")));

    }*/

    @Test
    public  void should_return_parsed_string_when_parse_given_string(){
        //given
        String argsText="-l true -p 8080 -d /usr/logs";
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        FlagSchema flagSchema_d = new FlagSchema("d", String.class);
        FlagSchema flagSchema_l = new FlagSchema("l", Boolean.class);
        FlagSchema flagSchema_p = new FlagSchema("p", Integer.class);
        flagSchemaSet.add(flagSchema_d);
        flagSchemaSet.add(flagSchema_l);
        flagSchemaSet.add(flagSchema_p);
        Schema schema = new Schema(flagSchemaSet);
        Args args=new Args(argsText,schema);

        //when
        args.scan();
        String result = args.print();
        System.out.println(result);
        //then
        assertEquals(true, result.contains("l true class java.lang.Boolean"));
    }
    @Test
    public  void should_return_parsed_string_when_parse_given_string_2(){
        //given
        String argsText="-l -p 8080 -d /usr/logs";
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        FlagSchema flagSchema_d = new FlagSchema("d", String.class);
        FlagSchema flagSchema_l = new FlagSchema("l", Boolean.class);
        FlagSchema flagSchema_p = new FlagSchema("p", Integer.class);
        flagSchemaSet.add(flagSchema_d);
        flagSchemaSet.add(flagSchema_l);
        flagSchemaSet.add(flagSchema_p);
        Schema schema = new Schema(flagSchemaSet);
        Args args=new Args(argsText,schema);

        //when
        args.scan();
        String result = args.print();
        System.out.println(result);
        //then
        assertEquals(true, result.contains("l true class java.lang.Boolean"));
    }
    @Test
    public  void should_return_parsed_string_when_parse_given_string_3(){
        //given
        String argsText="-l -p  -d /usr/logs";
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        FlagSchema flagSchema_d = new FlagSchema("d", String.class);
        FlagSchema flagSchema_l = new FlagSchema("l", Boolean.class);
        FlagSchema flagSchema_p = new FlagSchema("p", Integer.class);
        flagSchemaSet.add(flagSchema_d);
        flagSchemaSet.add(flagSchema_l);
        flagSchemaSet.add(flagSchema_p);
        Schema schema = new Schema(flagSchemaSet);
        Args args=new Args(argsText,schema);

        //when
        args.scan();
        String result = args.print();
        System.out.println(result);
        //then
        assertEquals(true, result.contains("p 0 class java.lang.Integer"));
    }
    @Test
    public  void should_return_parsed_string_when_parse_given_string_4(){
        //given
        String argsText="-l -p  -d  ";
        Set<FlagSchema> flagSchemaSet = new HashSet<FlagSchema>();
        FlagSchema flagSchema_d = new FlagSchema("d", String.class);
        FlagSchema flagSchema_l = new FlagSchema("l", Boolean.class);
        FlagSchema flagSchema_p = new FlagSchema("p", Integer.class);
        flagSchemaSet.add(flagSchema_d);
        flagSchemaSet.add(flagSchema_l);
        flagSchemaSet.add(flagSchema_p);
        Schema schema = new Schema(flagSchemaSet);
        Args args=new Args(argsText,schema);

        //when
        args.scan();
        String result = args.print();
        System.out.println(result);
        //then
        assertEquals(true, result.contains("d null class java.lang.String"));
    }

}

