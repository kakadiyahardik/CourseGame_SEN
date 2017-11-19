package root.Controller;

import java.util.Queue;

import root.Bean.Mail;

public class ThreadImplement implements Runnable {
	
	Queue<Mail> q;
	SendEmail send;
	
	public ThreadImplement(Queue<Mail> q) {
		 this.q = q;
		 send = new SendEmail();
	}
	
	public void run() {

		while(q.size()>0){
			Mail m = q.poll();
			System.out.println("Message "+m.getSubject()+" "+m.getTo()+" "+m.getMessage());
			send.SendEmail(m.getSubject(), m.getTo(), m.getMessage());
		}
		System.out.println("Done");
	}

}
