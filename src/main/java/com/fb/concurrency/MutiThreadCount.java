package com.fb.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class MutiThreadCount implements Callable<Long> {

	private AtomicInteger ai = new AtomicInteger();

	public MutiThreadCount() {
	}

	@Override
	public Long call() {
		Long start = System.currentTimeMillis();
		// synchronized (ai) {
		for (int i = 0; i < 100000; i++) {
			// System.out.println(Thread.currentThread().getId()
			// + " get num is :" + ai.get());
			ai.incrementAndGet();
		}
		// }
		Long end = System.currentTimeMillis();
		return end - start;

	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(1000);
		Long maxtime = 0l;
		MutiThreadCount mtc = new MutiThreadCount();
		List<Future<Long>> result = new ArrayList<Future<Long>>();
		for (int i = 0; i < 1000; i++) {
			Future<Long> time = es.submit(mtc);
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
		System.out.println(mtc.ai.get());
	}

}
