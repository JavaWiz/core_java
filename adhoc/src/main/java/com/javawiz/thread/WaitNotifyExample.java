package com.javawiz.thread;

import java.util.concurrent.ThreadLocalRandom;

public class WaitNotifyExample {

	public static void main(String[] args) {
		Data data = new Data();
		Thread sender = new Thread(new Sender(data));
		Thread receiver = new Thread(new Receiver(data));

		sender.start();
		receiver.start();
	}

}

/**
 * Let's take a closer look at this Sender: We're creating some random data
 * packets that will be sent across the network in packets[] array. For each
 * packet, we're merely calling send(). Then we're calling Thread.sleep() with
 * random interval to mimic heavy server-side processing.
 */

class Sender implements Runnable {
	private Data data;

	public Sender(Data data) {
		this.data = data;
	}

	public void run() {
		String packets[] = { "First packet", "Second packet", "Third packet", "Fourth packet", "End" };

		for (String packet : packets) {
			data.send(packet);
			System.out.println("packet data sent ...");
			try {
				// to mimic heavy server-side processing
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted" + e);
			}
		}
	}
}

class Receiver implements Runnable {
	private Data load;

	public Receiver(Data load) {
		this.load = load;
	}

	public void run() {
		for (String receivedMessage = load.receive(); !"End".equals(receivedMessage); receivedMessage = load
				.receive()) {

			System.out.println(receivedMessage);
			System.out.println("packet data received ...");
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted" + e);
			}
		}
	}
}

class Data {
	private String packet;

	// True if receiver should wait
	// False if sender should wait
	private boolean transfer = true;

	public synchronized String receive() {
		while (transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread Interrupted");
			}
		}
		transfer = true;

		String returnPacket = packet;
		notifyAll();
		return returnPacket;
	}

	public synchronized void send(String packet) {
		while (!transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread Interrupted");
			}
		}
		transfer = false;

		this.packet = packet;
		notifyAll();
	}
}
