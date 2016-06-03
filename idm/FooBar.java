package com.idm;
/**
 * This program should print each number from 1 to 100, replacing each multiple
 * of 5 with the word "foo", each multiple of 7 with the word "bar", and each
 * multiple of both 5 and 7 with the word "foobar".
 *
 * Please *do not* use Google during this test.
 **/
public class FooBar {
    public static void main(String[] args) {
    	
    	for(int i=1;i<=100;i++){
    		float divByFive=i%5;
    		float divBySeven=i%7;
    		if(divByFive==0 && divBySeven==0 ){
    			System.out.println("foobar");
    		}else if(divByFive==0){
    			System.out.println("foo");
    		}else if(divBySeven==0){
    			System.out.println("bar");
    		}else{
    			System.out.println(i);
    		}
    	}

    }
}
