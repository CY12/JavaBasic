package multiThraed;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskForMultiCompute {

    public static void main(String[] args) {

        FutureTaskForMultiCompute inst=new FutureTaskForMultiCompute();
        // 创建任务集合
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();
        // 创建线程池
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // 传入Callable对象创建FutureTask对象
            FutureTask<Integer> ft = new FutureTask<Integer>(inst.new ComputeTask(i, ""+i));
            taskList.add(ft);
            // 提交给线程池执行任务，也可以通过exec.invokeAll(taskList)一次性提交所有任务;
            exec.submit(ft);
        }

        System.out.println("所有计算任务提交完毕, 主线程接着干其他事情！");

        // 开始统计各计算线程计算结果
        Integer totalResult = 0;
        for (FutureTask<Integer> ft : taskList) {
            try {
                //FutureTask的get方法会自动阻塞,直到获取计算结果为止
                totalResult = totalResult + ft.get();
                System.out.println("totalResult"+totalResult+"  ft get "+ft.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 关闭线程池
        exec.shutdown();
        System.out.println("多任务计算后的总结果是:" + totalResult);

    }

    private class ComputeTask implements Callable<Integer> {

        private Integer result = 0;
        private String taskName = "";

        public ComputeTask(Integer iniResult, String taskName){
            result = iniResult;
            this.taskName = taskName;
            System.out.println("生成子线程计算任务: "+taskName+" result"+result);
        }

        public String getTaskName(){
            return this.taskName;
        }

        @Override
        public Integer call() throws Exception {
            // TODO Auto-generated method stub

//            for (int i = 0; i < 100; i++) {
//                result =+ i;
//            }

            // 休眠5秒钟，观察主线程行为，预期的结果是主线程会继续执行，到要取得FutureTask的结果是等待直至完成。
            Thread.sleep(5000);
            System.out.println("子线程计算任务: "+taskName+" 执行完成!");
            return result;
        }
    }
//    生成子线程计算任务: 0 result0
//    生成子线程计算任务: 1 result1
//    生成子线程计算任务: 2 result2
//    生成子线程计算任务: 3 result3
//    生成子线程计算任务: 4 result4
//    生成子线程计算任务: 5 result5
//    生成子线程计算任务: 6 result6
//    生成子线程计算任务: 7 result7
//    生成子线程计算任务: 8 result8
//    生成子线程计算任务: 9 result9
//    所有计算任务提交完毕, 主线程接着干其他事情！
//    子线程计算任务: 3 执行完成!
//    子线程计算任务: 2 执行完成!
//    子线程计算任务: 1 执行完成!
//    子线程计算任务: 0 执行完成!
//    子线程计算任务: 4 执行完成!
//    totalResult0  ft get 0
//    totalResult1  ft get 1
//    totalResult3  ft get 2
//    totalResult6  ft get 3
//    totalResult10  ft get 4
//    子线程计算任务: 8 执行完成!
//    子线程计算任务: 7 执行完成!
//    子线程计算任务: 6 执行完成!
//    子线程计算任务: 5 执行完成!
//    子线程计算任务: 9 执行完成!
//    totalResult15  ft get 5
//    totalResult21  ft get 6
//    totalResult28  ft get 7
//    totalResult36  ft get 8
//    totalResult45  ft get 9
//    多任务计算后的总结果是:45
}