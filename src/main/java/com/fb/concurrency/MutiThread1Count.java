package com.fb.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MutiThread1Count implements Callable<Long> {

	private volatile int counting;

	@Override
	public Long call() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			incr();
		}
		Long end = System.currentTimeMillis();
		return end - start;

	}

	public synchronized void incr() {
		counting++;
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		ExecutorService es = Executors.newFixedThreadPool(1000);
		Long maxtime = 0l;
		MutiThread1Count mtc1 = new MutiThread1Count();
		List<Future<Long>> result = new ArrayList<Future<Long>>();
		for (int i = 0; i < 1000; i++) {
			Future<Long> time = es.submit(mtc1);
			result.add(time);
		}

		es.shutdown();

		for (Future<Long> f : result) {
			Long time = f.get();
			if (time > maxtime) {
				maxtime = time;
			}
		}
		System.out.println(maxtime);
		System.out.println(mtc1.counting);
	}

}
