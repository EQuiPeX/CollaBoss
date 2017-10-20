import java.util.Random;

public class Task5 {
	
	static int[][] p1 = new int[2][10];
	static int[][] p2 = new int[2][10];
	static int[] p1sc = new int[10];
	static int[] p2sc = new int[10];
	
	public static void main(String[] args) {
		
		Random r = new Random(10);
		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < 2; j++) {
				p1[j][i]=0;
				p2[j][i]=0;
			}
		}
		int round = 0;
		while(round<10) {
			p1[0][round]=(int) ((Math.random())*11);
			if(p1[0][round] != 10) {
				p1[1][round]=(int) ((Math.random())*(11-p1[0][round]));
			}else {
				p1[1][round] = 0;
			}
			p2[0][round]=(int) ((Math.random())*11);
			if(p2[0][round] != 10) {
				p2[1][round]=(int) ((Math.random())*(11-p2[0][round]));
			}else {
				p2[1][round] = 0;
			}
			
			p1sc[round] = p1[0][round] + p1[1][round];
			p2sc[round] = p2[0][round] + p2[1][round];
			if(round >=2) {
				//strike
				if(p1[0][round-2] == 10) {
					if(p1[0][round-1] == 10) {
						p1sc[round-2] += p1[0][round-1] + p1[0][round];
					}else{
						p1sc[round-2] += p1[0][round-1] + p1[1][round-1]; 
					}
					//spare
				}else if((p1[0][round-2] + p1[1][round-2]) == 10) {
					p1sc[round-2] += p1[0][round-1];
				}
				//strike
				if(p2[0][round-2] == 10) {
					if(p2[0][round-1] == 10) {
						p2sc[round-2] += p2[0][round-1] + p2[0][round];
					}else{
						p2sc[round-2] += p2[0][round-1] + p2[1][round-1]; 
					}
					//spare
				}else if((p2[0][round-2] + p2[1][round-2]) == 10) {
					p2sc[round-2] += p2[0][round-1];
				}
				
			}
			if(round == 9) {
				p1sc[8] = devetap1();
				p1sc[9] = desetap1();
				p2sc[8] = devetap2();
				p2sc[9] = desetap2();
			}
			round++;
		}
		System.out.println("Player 1 frames:");
		for (int i = 0; i < round; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print("["+ p1[j][i] + "]");
			}System.out.println();
		}System.out.println();
		
		//Player1 score printout
		int p1score = 0;
		System.out.println("Player 1 score:");
		for (int i = 0; i < p1sc.length; i++) {
			p1score+= p1sc[i];
			if(i==9) {
				System.out.print(p1sc[i]);
			}else {
				System.out.print(p1sc[i]+"+");
			}
		}System.out.println("="+p1score);
		System.out.println();
		
		//Player 2 score printout
		System.out.println("Player 2 frames:");
		for (int i = 0; i < round; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print("["+ p2[j][i] + "]");
			}System.out.println();
		}
		System.out.println();
		int p2score = 0;
		System.out.println("Player 2 score:");
		for (int i = 0; i < p2sc.length; i++) {
			p2score+= p2sc[i];
			if(i==9) {
				System.out.print(p2sc[i]);
			}else {
				System.out.print(p2sc[i]+"+");
			}
		}System.out.println("="+p2score);
		System.out.println();
		if(p1score > p2score) {
			System.out.println("Winner: Player 1!");
		}else if(p1score < p2score) {
			System.out.println("Winner: Player 2!");
		}else {
			System.out.println("It's a tie!");
		}
		
	}
	public static int devetap1() {
		int score = 0;
		if(p1[0][8]==10 && p1[0][9] == 10){//strike x2
			score=p1[0][8] + p1[0][9] + (int) ((Math.random())*11);
		}else if(p1[0][8] == 10) {//strike x1
			score = p1[0][8] + p1[0][9] + p1[1][9];
		}else if(p1[0][8] + p1[1][8] == 10){//spare
			score = p1[0][8] + p1[1][8] + p1[0][9];
		}else{//none
			score = p1[0][8] + p1[1][8];
		}
		return score;
	}
	public static int desetap1() {
		int score = 0;
		int x = (int) ((Math.random())*11);
		int y = (int) ((Math.random())*(11-x));
		if(p1[0][9]==10) {//strike
			score = p1[0][9]+ x + y;
		}else if(p1[0][9]+p1[1][9]==10) {//spare
				score=p1[0][9] + p1[1][9]+ x;
		}else{//none
			score = p1[0][9] + p1[1][9] ;
		}
		return score;
	}
	public static int devetap2() {
		int score = 0;
		if(p2[0][8]==10 && p2[0][9] == 10){//strike x2
			score=p2[0][8] + p2[0][9] + (int) ((Math.random())*11);
		}else if(p2[0][8] == 10) {//strike x1
			score = p2[0][8] + p2[0][9] + p2[1][9];
		}else if(p2[0][8] + p2[1][8] == 10){//spare
			score = p2[0][8] + p2[1][8] + p2[0][9];
		}else{//none
			score = p2[0][8] + p2[1][8];
		}
		return score;
	}
	public static int desetap2() {
		int score = 0;
		int x = (int) ((Math.random())*11);
		int y = (int) ((Math.random())*(11-x));
		if(p2[0][9]==10) {//strike
			score = p2[0][9]+ x + y;
		}else if(p2[0][9]+p2[1][9]==10) {//spare
				score=p2[0][9] + p2[1][9]+ x;
		}else{//none
			score = p2[0][9] + p2[1][9] ;
		}
		return score;
	}
}