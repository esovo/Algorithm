import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, max;
	static int[] T, P;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		dfs(0, 0);
		System.out.println(max);
	}
	
	private static void dfs(int day, int cost) {
		if(day == N) {
			max = Math.max(cost, max);
			return;
		}
		
		// 상담 완료일이 퇴사 전인지 확인
		if(day+T[day]<=N) {
			dfs(day+T[day], cost+P[day]);			
		}
		dfs(day+1, cost);
	}
}