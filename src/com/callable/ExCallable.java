
package com.callable;

import java.util.concurrent.Callable;

/**
 * Created by Sudheer.
 */
public class ExCallable implements Callable<Object> {
    int i;
    public ExCallable(int i){
        this.i=i;
    }
    @Override
    public Object call() throws Exception {
        System.out.println("*********************File" +i+"*****************");
        return "rtrt";
    }
}
