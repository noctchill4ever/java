package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("价格为："+aDouble);
            }
        });
        System.out.println("=======================");
        happyTime(400,money->System.out.println("价格为："+money));
    }
    public void happyTime(double money, Consumer<Double>con){
        con.accept(money);
    }
    @Test
    public void test2(){
        List<String>list= Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);
        System.out.println("==================");
        List<String> filterStr1= filterString(list, s -> s.contains("京"));
        System.out.println(filterStr1);
    }
    public List<String> filterString(List<String>list, Predicate<String>pre){
        ArrayList<String> filterList=new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
